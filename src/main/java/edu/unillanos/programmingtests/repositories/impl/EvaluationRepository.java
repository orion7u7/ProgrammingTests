package edu.unillanos.programmingtests.repositories.impl;

import edu.unillanos.programmingtests.models.Evaluation;
import edu.unillanos.programmingtests.repositories.jpa.EvaluationRepositoryJpa;
import edu.unillanos.programmingtests.utils.Mappers.EvaluationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EvaluationRepository {

    private final EvaluationRepositoryJpa evaluationRepositoryJpa;

    public List<Evaluation> findAll() {
        return EvaluationMapper.entityListToModelList(evaluationRepositoryJpa.findAll());
    }

    public Evaluation findById(Long id) {
        return EvaluationMapper.entityToModel(evaluationRepositoryJpa.findById(id).orElse(null));
    }

    public Evaluation save(Evaluation evaluation) {
        return EvaluationMapper.entityToModel(evaluationRepositoryJpa.save(EvaluationMapper.modelToEntity(evaluation)));
    }
}
