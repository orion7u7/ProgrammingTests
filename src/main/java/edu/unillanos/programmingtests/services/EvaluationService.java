package edu.unillanos.programmingtests.services;

import edu.unillanos.programmingtests.models.Evaluation;
import edu.unillanos.programmingtests.repositories.impl.EvaluationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    public EvaluationService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

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
