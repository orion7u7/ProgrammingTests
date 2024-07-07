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
    private Long id;
    private String sourceCode;
    private String result;
    private Long userId;
    private Long problemId;
    private Long evaluationId;
}
