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
    private String result;
    private long userId;
    private long problemId;
    private long evaluationId;

    public Answer(long l, String s, long l1, long l2, long l3) {
    }
}
