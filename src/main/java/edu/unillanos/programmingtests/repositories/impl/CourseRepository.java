package edu.unillanos.programmingtests.repositories.impl;

import edu.unillanos.programmingtests.entities.CourseEntity;
import edu.unillanos.programmingtests.models.Course;
import edu.unillanos.programmingtests.repositories.jpa.CourseRepositoryJpa;
import edu.unillanos.programmingtests.utils.Mappers.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CourseRepository {

    private final CourseRepositoryJpa courseRepositoryJpa;

    public List<Course> findAll() {
        return CourseMapper.entityListToModelList(courseRepositoryJpa.findAll());
    }

    public Course findById(Long id) {
        return CourseMapper.entityToModel(courseRepositoryJpa.findById(id).orElse(null));
    }

    public Course save(Course course) {
        CourseEntity courseEntity = new CourseEntity();

        courseEntity.setId(course.getId());
        courseEntity.setName(course.getName());
        courseEntity.setDescription(course.getDescription());

        return CourseMapper.entityToModel(courseRepositoryJpa.save(courseEntity));
    }

}
