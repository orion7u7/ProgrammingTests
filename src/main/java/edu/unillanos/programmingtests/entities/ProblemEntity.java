package edu.unillanos.programmingtests.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "problems")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProblemEntity {

    @Id
    @Column(name = "id_problem")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description_problem", length = 2000)
    private String description;

}