package edu.unillanos.programmingtests.utils.Mappers;

import edu.unillanos.programmingtests.controllers.request.AnswerDTO;
import edu.unillanos.programmingtests.entities.AnswerEntity;
import edu.unillanos.programmingtests.entities.EvaluationEntity;
import edu.unillanos.programmingtests.entities.ProblemEntity;
import edu.unillanos.programmingtests.entities.UserEntity;
import edu.unillanos.programmingtests.models.Answer;

import java.util.List;
import java.util.stream.Collectors;

public class AnswerMapper {

    public static List<Answer> entityListToModelList(List<AnswerEntity> answerEntities) {
        return answerEntities.stream().map(AnswerMapper::entityToModel).collect(Collectors.toList());
    }

    public static Answer entityToModel(AnswerEntity answerEntity) {
        return new Answer(answerEntity.getId(), answerEntity.getSourceCode(), answerEntity.getResult(), answerEntity.getUser().getId(), answerEntity.getProblem().getId(), answerEntity.getEvaluation().getId());
    }

    public static AnswerEntity modelToEntity(Answer answer) {
        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setId(answer.getId());
        answerEntity.setSourceCode(answer.getSourceCode());
        answerEntity.setResult(answer.getResult());

        UserEntity userEntity = new UserEntity();
        userEntity.setId(answer.getUserId());
        answerEntity.setUser(userEntity);

        ProblemEntity problemEntity = new ProblemEntity();
        problemEntity.setId(answer.getProblemId());
        answerEntity.setProblem(problemEntity);

        EvaluationEntity evaluationEntity = new EvaluationEntity();
        evaluationEntity.setId(answer.getEvaluationId());
        answerEntity.setEvaluation(evaluationEntity);

        return answerEntity;
    }

    public static Answer dtoToModel(AnswerDTO answerDTO) {
        return new Answer(answerDTO.getId(), answerDTO.getSourceCode(), answerDTO.getResult(), answerDTO.getUser(), answerDTO.getProblem(), answerDTO.getEvaluation());
    }
}
