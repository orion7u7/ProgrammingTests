package edu.unillanos.programmingtests.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cases")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CaseEntity {

    @Id
    @Column(name = "id_case")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "input_case")
    private String input;

    @Column(name = "output_case")
    private String output;

    @ManyToOne
    @JoinColumn(name = "id_problem")
    private ProblemEntity problemId;


}
