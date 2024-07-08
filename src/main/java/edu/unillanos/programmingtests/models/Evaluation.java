package edu.unillanos.programmingtests.models;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Evaluation {
    private Long id;
    private String name;
    private String date;
    private List<Problem> problems;

}
