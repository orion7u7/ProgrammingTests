package edu.unillanos.programmingtests.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Problem {
    private Long id;
    private String description;
    private Long evaluationId;
}
