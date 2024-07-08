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
    private long id;
    private String sourceCode;
    private int result;
    private long user;
    private long problem;
    private long evaluation;
}
