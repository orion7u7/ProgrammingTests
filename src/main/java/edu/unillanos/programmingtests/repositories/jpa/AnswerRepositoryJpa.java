package edu.unillanos.programmingtests.repositories.jpa;

import edu.unillanos.programmingtests.entities.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepositoryJpa extends JpaRepository<AnswerEntity, Long> {
}
