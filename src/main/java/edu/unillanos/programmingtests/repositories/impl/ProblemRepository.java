package edu.unillanos.programmingtests.repositories.impl;

import edu.unillanos.programmingtests.models.Problem;
import edu.unillanos.programmingtests.repositories.jpa.ProblemRepositoryJpa;
import edu.unillanos.programmingtests.utils.Mappers.ProblemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProblemRepository {

    private final ProblemRepositoryJpa problemRepositoryJpa;

    public List<Problem> findAll() {
        return ProblemMapper.entityListToModelList(problemRepositoryJpa.findAll());
    }

    public Problem findById(Long id) {
        return ProblemMapper.entityToModel(problemRepositoryJpa.findById(id).orElse(null));
    }

    public Problem save(Problem problem) {
        return ProblemMapper.entityToModel(problemRepositoryJpa.save(ProblemMapper.modelToEntity(problem)));
    }
}
