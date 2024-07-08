package edu.unillanos.programmingtests.repositories.jpa;


import edu.unillanos.programmingtests.entities.CaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaseRepositoryJpa extends JpaRepository<CaseEntity, Long> {
    List<CaseEntity> findByProblemId(long problemId);
}
