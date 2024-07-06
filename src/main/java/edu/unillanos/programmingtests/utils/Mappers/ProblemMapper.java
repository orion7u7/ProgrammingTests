package edu.unillanos.programmingtests.utils.Mappers;

import edu.unillanos.programmingtests.controllers.request.ProblemDTO;
import edu.unillanos.programmingtests.entities.EvaluationEntity;
import edu.unillanos.programmingtests.entities.ProblemEntity;
import edu.unillanos.programmingtests.models.Problem;

import java.util.List;
import java.util.stream.Collectors;

public class ProblemMapper {

    public static Problem entityToModel(ProblemEntity problemEntity) {
        return new Problem(problemEntity.getId(), problemEntity.getDescription(), problemEntity.getEvaluationId().getId());
    }

    public static List<Problem> entityListToModelList(List<ProblemEntity> problemEntityList) {
        return problemEntityList.stream().map(ProblemMapper::entityToModel).collect(Collectors.toList());
    }

    public static ProblemEntity modelToEntity(Problem problem) {
        ProblemEntity problemEntity = new ProblemEntity();
        problemEntity.setId(problem.getId());
        problemEntity.setDescription(problem.getDescription());

        EvaluationEntity evaluationEntity = new EvaluationEntity();

        evaluationEntity.setId(problem.getEvaluationId());
        problemEntity.setEvaluationId(evaluationEntity);

        return problemEntity;
    }

    public static Problem dtoToModel(ProblemDTO problem) {
        return new Problem(problem.getId(), problem.getDescription(), problem.getEvaluation().getId());
    }
}
