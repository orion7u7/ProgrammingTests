package edu.unillanos.programmingtests.repositories.jpa;


import edu.unillanos.programmingtests.entities.CaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepositoryJpa extends JpaRepository<CaseEntity, Long> {
}
