package edu.unillanos.programmingtests.controllers;

import edu.unillanos.programmingtests.controllers.request.CaseDTO;
import edu.unillanos.programmingtests.controllers.responses.CustomResponse;
import edu.unillanos.programmingtests.services.CaseService;
import edu.unillanos.programmingtests.utils.Mappers.CaseMapper;
import edu.unillanos.programmingtests.utils.Mappers.GenericMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cases")
@RequiredArgsConstructor
public class CaseController {

    private final CaseService caseService;
    private final GenericMapper genericMapper;

    @GetMapping
    public CustomResponse<List> findAll() {
        return new CustomResponse<>(genericMapper.mapList(caseService.findAll(), CaseDTO.class), HttpStatus.OK, "Cases found successfully");
    }

    @GetMapping("/{id}")
    public CustomResponse<CaseDTO> findById(@PathVariable Long id) {
        return new CustomResponse<>(genericMapper.map(caseService.findById(id), CaseDTO.class), HttpStatus.OK, "Case found successfully");
    }

    @GetMapping("/problem/{problemId}")
    public CustomResponse<List> findByProblemId(@PathVariable Long problemId) {
        return new CustomResponse<>(genericMapper.mapList(caseService.findByProblemId(problemId), CaseDTO.class), HttpStatus.OK, "Cases found successfully");
    }

    @PostMapping("/create")
    public CustomResponse<CaseDTO> save(@RequestBody CaseDTO caseModel) {
        return new CustomResponse<>(genericMapper.map(caseService.save(CaseMapper.dtoToModel(caseModel)), CaseDTO.class), HttpStatus.OK, "Case created successfully");
    }
}
