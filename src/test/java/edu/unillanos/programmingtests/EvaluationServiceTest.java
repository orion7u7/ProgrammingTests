package edu.unillanos.programmingtests;

import edu.unillanos.programmingtests.models.Answer;
import edu.unillanos.programmingtests.models.Case;
import edu.unillanos.programmingtests.repositories.impl.AnswerRepository;
import edu.unillanos.programmingtests.repositories.impl.CaseRepository;
import edu.unillanos.programmingtests.repositories.impl.EvaluationRepository;
import edu.unillanos.programmingtests.services.EvaluationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EvaluationServiceTest {

    @Mock
    private EvaluationRepository evaluationRepository;

    @Mock
    private AnswerRepository answerRepository;

    @Mock
    private CaseRepository caseRepository;

    @InjectMocks
    private EvaluationService evaluationService;

    @Test
    public void testEvaluation() throws IOException, InterruptedException {
        when(answerRepository.findById(anyLong())).thenReturn(
                new Answer(1L, """
                            public String test(String text){
                                                
                                for (int i = 0; i < text.length() /2; i++) {
                                    if (text.charAt(i)!=text.charAt((text.length()-1)-i)){
                                        return "false";
                                    }
                                }
                                             
                                return "true";
                            }              
                        """, "Correcto", 1L, 1L, 1L)
        );

        when(caseRepository.findByProblemId(anyLong())).thenReturn(
               List.of(
                       new Case(1L,"anitalavalatina","true",1L),
                       new Case(1L,"paloma","false",1L),
                       new Case(1L,"radar","true",1L)
                       )
        );

        evaluationService.evaluarRespuesta(1L);
    }
}
