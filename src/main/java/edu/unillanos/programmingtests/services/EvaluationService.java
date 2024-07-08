package edu.unillanos.programmingtests.services;

import edu.unillanos.programmingtests.models.Answer;
import edu.unillanos.programmingtests.models.Case;
import edu.unillanos.programmingtests.models.Evaluation;
import edu.unillanos.programmingtests.repositories.impl.AnswerRepository;
import edu.unillanos.programmingtests.repositories.impl.CaseRepository;
import edu.unillanos.programmingtests.repositories.impl.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    private final AnswerRepository answerRepository;

    private final CaseRepository caseRepository;

    public List<Evaluation> findAll() {
        return evaluationRepository.findAll();
    }

    public Evaluation findById(Long id) {
        return evaluationRepository.findById(id);
    }

    public Evaluation save(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    public void evaluarRespuesta(Long respuestaId) throws IOException, InterruptedException {

        Answer respuesta = answerRepository.findById(respuestaId);

        if (respuesta == null) {
            throw new IllegalArgumentException("Respuesta no encontrada");
        }

        String className = "Answer" + respuesta.getId();

        for (Case casoPrueba : caseRepository.findByProblemId(respuesta.getProblemId())) {

            File codigoFuenteFile = getFile(casoPrueba, className, respuesta);

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
                log.info("correcto");
                respuesta.setResult("Correcto");
            } else {
                log.info("incorrecto");
                respuesta.setResult("Incorrecto");
            }

            answerRepository.save(respuesta);

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
