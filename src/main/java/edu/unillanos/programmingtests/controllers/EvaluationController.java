package edu.unillanos.programmingtests.controllers;

import edu.unillanos.programmingtests.controllers.request.EvaluationDTO;
import edu.unillanos.programmingtests.controllers.responses.CustomResponse;
import edu.unillanos.programmingtests.services.EvaluationService;
import edu.unillanos.programmingtests.utils.Mappers.EvaluationMapper;
import edu.unillanos.programmingtests.utils.Mappers.GenericMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluations")
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationService evaluationService;
    private final GenericMapper genericMapper;

    @GetMapping
    public CustomResponse<List> findAll() {
        return new CustomResponse<>(genericMapper.mapList(evaluationService.findAll(), EvaluationDTO.class), HttpStatus.OK, "Evaluations found successfully");
    }

    @GetMapping("/{id}")
    public CustomResponse<EvaluationDTO> findById(@RequestParam Long id) {
        return new CustomResponse<>(genericMapper.map(evaluationService.findById(id), EvaluationDTO.class), HttpStatus.OK, "Evaluation found successfully");
    }

    @PostMapping("/create")
    public CustomResponse<EvaluationDTO> save(@RequestBody EvaluationDTO evaluation) {
        return new CustomResponse<>(genericMapper.map(evaluationService.save(EvaluationMapper.dtoToModel(evaluation)), EvaluationDTO.class), HttpStatus.OK, "Evaluation created successfully");
    }
}
