package edu.unillanos.programmingtests.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Answer {
    private long id;
    private String sourceCode;
    private int result;
    private long userId;
    private long problemId;
    private long evaluationId;

}
