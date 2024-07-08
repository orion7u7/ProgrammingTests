package edu.unillanos.programmingtests.services;

import edu.unillanos.programmingtests.models.Answer;
import edu.unillanos.programmingtests.models.Case;
import edu.unillanos.programmingtests.repositories.impl.AnswerRepository;
import edu.unillanos.programmingtests.repositories.impl.CaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final EvaluationService evaluationService;
    private final CaseRepository caseRepository;

    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    public Answer findById(Long id) {
        return answerRepository.findById(id);
    }

    public Answer save(Answer answer) throws IOException, InterruptedException {
        Answer answerSaved= answerRepository.save(answer);
        evaluateAnswer(answerSaved.getId());

        return findById(answerSaved.getId());
    }

    public void evaluateAnswer(Long respuestaId) throws IOException, InterruptedException {

        Answer answer = answerRepository.findById(respuestaId);

        if (answer == null) {
            throw new IllegalArgumentException("Respuesta no encontrada");
        }

        String className = "Answer" + answer.getId();

        for (Case casoPrueba : caseRepository.findByProblemId(answer.getProblemId())) {

            File codigoFuenteFile = getFile(casoPrueba, className, answer);

            ProcessBuilder compileProcessBuilder = new ProcessBuilder("javac", codigoFuenteFile.getName());
            Process compileProcess = compileProcessBuilder.start();
            compileProcess.waitFor();

            if (compileProcess.exitValue() != 0) {
                log.error("Error de compilación");
                return;
            } else {
                log.info("Compiló correctamente");
            }

            ProcessBuilder runProcessBuilder = new ProcessBuilder("java", className);
            runProcessBuilder.redirectInput(ProcessBuilder.Redirect.PIPE);
            runProcessBuilder.redirectOutput(ProcessBuilder.Redirect.PIPE);
            Process runProcess = runProcessBuilder.start();

            StringBuilder output = new StringBuilder();
            try (BufferedReader outputReader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()))) {
                String line;
                while ((line = outputReader.readLine()) != null) {
                    output.append(line).append("\n");
                }
            }

            runProcess.waitFor();

            if (output.toString().trim().equals(casoPrueba.getOutput().trim())) {
                answer.setResult(answer.getResult() +1);
            }

            answerRepository.save(answer);

            codigoFuenteFile.delete();
            new File(className + ".class").delete();
        }
    }

    private File getFile(Case casoPrueba, String className, Answer respuesta) throws IOException {
        String CODE_FINAL = """
                public class #class_name{
                            
                   public static void main(String[] args) {
                      #method_calling
                   }
                   
                   #method
                }
                """;
        String completeCode = CODE_FINAL
                .replace("#method_calling", "System.out.print(new " + className + "().test(\"" + casoPrueba.getInput().replaceAll("\n", "\\n").replaceAll("\"", "\\\"") + "\"));")
                .replace("#method", respuesta.getSourceCode())
                .replace("#class_name", className);

        File codigoFuenteFile = new File(className + ".java");
        try (FileWriter writer = new FileWriter(codigoFuenteFile)) {
            writer.write(completeCode);
        }
        return codigoFuenteFile;
    }
}
