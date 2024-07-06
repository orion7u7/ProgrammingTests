package edu.unillanos.programmingtests.repositories.jpa;

import edu.unillanos.programmingtests.entities.CourseEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepositoryJpa extends JpaRepository<CourseEntity, Long> {


}
