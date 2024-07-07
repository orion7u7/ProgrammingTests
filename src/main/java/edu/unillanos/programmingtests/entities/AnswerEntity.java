package edu.unillanos.programmingtests.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "answers")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AnswerEntity {

    @Id
    @Column(name = "id_answer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sourceCode_answer")
    private String sourceCode;

    @Column(name = "result_answer")
    private String result;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id_problem")
    private ProblemEntity problem;

    @ManyToOne
    @JoinColumn(name = "id_evaluation")
    private EvaluationEntity evaluation;
}
