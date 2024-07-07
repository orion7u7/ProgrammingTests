package edu.unillanos.programmingtests.controllers;

import edu.unillanos.programmingtests.controllers.request.AnswerDTO;
import edu.unillanos.programmingtests.controllers.responses.CustomResponse;
import edu.unillanos.programmingtests.services.AnswerService;
import edu.unillanos.programmingtests.utils.Mappers.AnswerMapper;
import edu.unillanos.programmingtests.utils.Mappers.GenericMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;
    private final GenericMapper genericMapper;

    @GetMapping
    public CustomResponse<List> findAll() {
        return new CustomResponse<>(genericMapper.mapList(answerService.findAll(), AnswerDTO.class), HttpStatus.OK, "Answers found successfully");
    }

    @GetMapping("/{id}")
    public CustomResponse<AnswerDTO> findById(Long id) {
        return new CustomResponse<>(genericMapper.map(answerService.findById(id), AnswerDTO.class), HttpStatus.OK, "Answer found successfully");
    }

    @PostMapping("/create")
    public CustomResponse<AnswerDTO> save(AnswerDTO answer) {
        return new CustomResponse<>(genericMapper.map(answerService.save(AnswerMapper.dtoToModel(answer)), AnswerDTO.class), HttpStatus.OK, "Answer created successfully");
    }
}