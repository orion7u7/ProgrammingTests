package edu.unillanos.programmingtests.controllers.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProblemDTO {
    Long id;
    String description;
    EvaluationDTO evaluation;
}
