package edu.unillanos.programmingtests.utils.Mappers;


import edu.unillanos.programmingtests.controllers.request.CourseDTO;
import edu.unillanos.programmingtests.entities.CourseEntity;
import edu.unillanos.programmingtests.models.Course;

import java.util.List;
import java.util.stream.Collectors;

public class CourseMapper {

    public static List<Course> entityListToModelList(List<CourseEntity> courseEntityList) {
        return courseEntityList.stream().map(CourseMapper::entityToModel).collect(Collectors.toList());
    }

    public static Course entityToModel(CourseEntity courseEntity) {
        return new Course(courseEntity.getId(), courseEntity.getName(), courseEntity.getDescription());
    }

    public static CourseEntity modelToEntity(Course course) {
        return new CourseEntity(course.getId(), course.getName(), course.getDescription());
    }

    public static Course dtoToModel(CourseDTO course) {
        return new Course(course.getId(), course.getName(), course.getDescription());
    }
}
