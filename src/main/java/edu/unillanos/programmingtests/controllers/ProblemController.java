package edu.unillanos.programmingtests.controllers;

import edu.unillanos.programmingtests.controllers.request.ProblemDTO;
import edu.unillanos.programmingtests.controllers.responses.CustomResponse;
import edu.unillanos.programmingtests.services.ProblemService;
import edu.unillanos.programmingtests.utils.Mappers.GenericMapper;
import edu.unillanos.programmingtests.utils.Mappers.ProblemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/problems")
@RequiredArgsConstructor
public class ProblemController {

    private final ProblemService problemService;
    private final GenericMapper genericMapper;

    @GetMapping
    public CustomResponse<List> findAll() {
        return new CustomResponse<>(genericMapper.mapList(problemService.findAll(), ProblemDTO.class), HttpStatus.OK, "Problems found successfully");
    }

    @GetMapping("/{id}")
    public CustomResponse<ProblemDTO> findById(Long id) {
        return new CustomResponse<>(genericMapper.map(problemService.findById(id), ProblemDTO.class), HttpStatus.OK, "Problem found successfully");
    }

    @PostMapping("/create")
    public CustomResponse<ProblemDTO> save(ProblemDTO problem) {
        return new CustomResponse<>(genericMapper.map(problemService.save(ProblemMapper.dtoToModel(problem)), ProblemDTO.class), HttpStatus.OK, "Problem created successfully");
    }
}
