package edu.unillanos.programmingtests.controllers.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnswerDTO {
    private Long id;
    private String sourceCode;
    private String result;
    private UserDTO user;
    private ProblemDTO problem;
    private EvaluationDTO evaluation;
}
