package edu.unillanos.programmingtests.repositories.jpa;

import edu.unillanos.programmingtests.entities.UserEntity;
import edu.unillanos.programmingtests.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryJpa extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

}
