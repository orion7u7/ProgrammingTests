package edu.unillanos.programmingtests.utils.Mappers;

import edu.unillanos.programmingtests.controllers.request.EvaluationDTO;
import edu.unillanos.programmingtests.entities.CourseEntity;
import edu.unillanos.programmingtests.entities.EvaluationEntity;
import edu.unillanos.programmingtests.models.Evaluation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class EvaluationMapper {

    public static Evaluation entityToModel(EvaluationEntity evaluationEntity) {
        return new Evaluation(evaluationEntity.getId(), evaluationEntity.getName(), evaluationEntity.getDate().toString(), evaluationEntity.getCourseId().getId());
    }

    public static List<Evaluation> entityListToModelList(List<EvaluationEntity> evaluationEntityList) {
        return evaluationEntityList.stream().map(EvaluationMapper::entityToModel).collect(Collectors.toList());
    }

    public static Evaluation dtoToModel(EvaluationDTO evaluation) {
        return new Evaluation(evaluation.getId(), evaluation.getName(), evaluation.getDate(), evaluation.getCourse().getId());
    }

    public static EvaluationEntity modelToEntity(Evaluation evaluation) {
        EvaluationEntity evaluationEntity = new EvaluationEntity();
        evaluationEntity.setId(evaluation.getId());
        evaluationEntity.setName(evaluation.getName());
        evaluationEntity.setDate(LocalDateTime.parse(evaluation.getDate()));

        CourseEntity courseEntity = new CourseEntity();

        courseEntity.setId(evaluation.getCourseId());
        evaluationEntity.setCourseId(courseEntity);

        return evaluationEntity;
    }
}
