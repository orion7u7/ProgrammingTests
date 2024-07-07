package edu.unillanos.programmingtests.controllers;

import edu.unillanos.programmingtests.controllers.request.CourseDTO;
import edu.unillanos.programmingtests.controllers.responses.CustomResponse;
import edu.unillanos.programmingtests.services.CourseService;
import edu.unillanos.programmingtests.utils.Mappers.CourseMapper;
import edu.unillanos.programmingtests.utils.Mappers.GenericMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CoursesController {

    private final CourseService courseService;
    private final GenericMapper genericMapper;

    @GetMapping
    public CustomResponse<List> findAll() {
        return new CustomResponse<>(genericMapper.mapList(courseService.findAll(), CourseDTO.class), HttpStatus.OK, "Courses found successfully");
    }

    @GetMapping("/{id}")
    public CustomResponse<CourseDTO> findById(@RequestParam Long id) {
        return new CustomResponse<>(genericMapper.map(courseService.findById(id), CourseDTO.class), HttpStatus.OK, "Course found successfully");
    }

    @PostMapping("/create")
    public CustomResponse<CourseDTO> save(@RequestBody CourseDTO course) {
        return new CustomResponse<>(genericMapper.map(courseService.save(CourseMapper.dtoToModel(course)), CourseDTO.class), HttpStatus.OK, "Course created successfully");
    }
}
