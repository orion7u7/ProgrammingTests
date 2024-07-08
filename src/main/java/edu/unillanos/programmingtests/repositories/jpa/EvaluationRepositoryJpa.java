package edu.unillanos.programmingtests.repositories.jpa;


import edu.unillanos.programmingtests.entities.EvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepositoryJpa extends JpaRepository<EvaluationEntity, Long> {

}
