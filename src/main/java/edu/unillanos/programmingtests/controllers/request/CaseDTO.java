package edu.unillanos.programmingtests.controllers.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CaseDTO {
    private Long id;
    private String input;
    private String output;
    private ProblemDTO problem;
}
