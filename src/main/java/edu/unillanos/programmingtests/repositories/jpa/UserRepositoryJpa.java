package edu.unillanos.programmingtests.repositories.jpa;

import edu.unillanos.programmingtests.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJpa  extends JpaRepository<UserEntity, Long> {
}
