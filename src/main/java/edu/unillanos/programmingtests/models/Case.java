package edu.unillanos.programmingtests.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Case {
    private Long id;
    private String input;
    private String output;
    private Long problemId;
}
