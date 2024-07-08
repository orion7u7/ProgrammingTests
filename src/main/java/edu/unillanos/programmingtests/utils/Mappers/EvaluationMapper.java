package edu.unillanos.programmingtests.utils.Mappers;

import edu.unillanos.programmingtests.controllers.request.EvaluationDTO;
import edu.unillanos.programmingtests.entities.EvaluationEntity;
import edu.unillanos.programmingtests.entities.ProblemEntity;
import edu.unillanos.programmingtests.models.Evaluation;
import edu.unillanos.programmingtests.models.Problem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class EvaluationMapper {

    public static Evaluation entityToModel(EvaluationEntity evaluationEntity) {
        List<Problem> problems = evaluationEntity.getProblems().stream().map(problemEntity -> new Problem(problemEntity.getId(), problemEntity.getDescription())).collect(Collectors.toList());
        return new Evaluation(evaluationEntity.getId(), evaluationEntity.getName(), evaluationEntity.getDate().toString(), problems);
    }

    public static List<Evaluation> entityListToModelList(List<EvaluationEntity> evaluationEntityList) {
        return evaluationEntityList.stream().map(EvaluationMapper::entityToModel).collect(Collectors.toList());
    }

    public static EvaluationDTO modelToDTO(Evaluation evaluation) {
        EvaluationDTO evaluationDTO = new EvaluationDTO();
        evaluationDTO.setId(evaluation.getId());
        evaluationDTO.setName(evaluation.getName());
        evaluationDTO.setDate(evaluation.getDate());
        evaluationDTO.setProblems(evaluation.getProblems().stream().map(Problem::getId).collect(Collectors.toList()));

        return evaluationDTO;
    }

    public static Evaluation dtoToModel(EvaluationDTO evaluationDTO) {
        List<Problem> problems = evaluationDTO.getProblems().stream().map(problemId -> new Problem(problemId, null)).collect(Collectors.toList());
        return new Evaluation(evaluationDTO.getId(), evaluationDTO.getName(), evaluationDTO.getDate(), problems);
    }

    public static EvaluationEntity modelToEntity(Evaluation evaluation) {
        EvaluationEntity evaluationEntity = new EvaluationEntity();
        evaluationEntity.setId(evaluation.getId());
        evaluationEntity.setName(evaluation.getName());
        evaluationEntity.setDate(LocalDateTime.parse(evaluation.getDate()));
        List<ProblemEntity> problemEntities = evaluation.getProblems().stream().map(problem -> new ProblemEntity(problem.getId(), problem.getDescription())).collect(Collectors.toList());
        evaluationEntity.setProblems(problemEntities);

        return evaluationEntity;
    }



}
