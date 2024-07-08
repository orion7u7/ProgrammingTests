package edu.unillanos.programmingtests.services;

import edu.unillanos.programmingtests.models.Answer;
import edu.unillanos.programmingtests.models.Case;
import edu.unillanos.programmingtests.models.Evaluation;
import edu.unillanos.programmingtests.repositories.impl.AnswerRepository;
import edu.unillanos.programmingtests.repositories.impl.CaseRepository;
import edu.unillanos.programmingtests.repositories.impl.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    public List<Evaluation> findAll() {
        return evaluationRepository.findAll();
    }

    public Evaluation findById(Long id) {
        return evaluationRepository.findById(id);
    }

    public Evaluation save(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }




}
