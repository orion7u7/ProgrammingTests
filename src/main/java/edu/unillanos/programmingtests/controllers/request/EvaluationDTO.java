package edu.unillanos.programmingtests.controllers.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EvaluationDTO {
    private Long id;
    private String name;
    private String date;
    private CourseDTO course;

}
