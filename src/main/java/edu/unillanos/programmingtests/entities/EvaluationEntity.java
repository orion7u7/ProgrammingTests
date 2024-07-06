package edu.unillanos.programmingtests.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "evaluations")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EvaluationEntity {

    @Id
    @Column(name = "id_evaluation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_evaluation")
    private String name;

    @Column(name = "date_evaluation")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false)
    private CourseEntity courseId;
}

