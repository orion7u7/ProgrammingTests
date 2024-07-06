package edu.unillanos.programmingtests.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "problems")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProblemEntity {

    @Id
    @Column(name = "id_problem")
    @GeneratedValue
    private Long id;

    @Column(name = "description_problem")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_evaluation", nullable = false)
    private EvaluationEntity evaluationId;
}
