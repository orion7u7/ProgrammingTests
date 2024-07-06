package edu.unillanos.programmingtests.repositories.jpa;

import edu.unillanos.programmingtests.entities.ProblemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepositoryJpa extends JpaRepository<ProblemEntity, Long> {
}
