package edu.unillanos.programmingtests.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Evaluation {
    private Long id;
    private String name;
    private String date;
    private Long courseId;

}
