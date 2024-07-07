package edu.unillanos.programmingtests.repositories.impl;

import edu.unillanos.programmingtests.models.Answer;
import edu.unillanos.programmingtests.repositories.jpa.AnswerRepositoryJpa;
import edu.unillanos.programmingtests.utils.Mappers.AnswerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AnswerRepository {

    private final AnswerRepositoryJpa answerRepositoryJpa;

    public List<Answer> findAll() {
        return AnswerMapper.entityListToModelList(answerRepositoryJpa.findAll());
    }

    public Answer findById(Long id) {
        return AnswerMapper.entityToModel(answerRepositoryJpa.findById(id).orElse(null));
    }

    public Answer save(Answer answer) {
        return AnswerMapper.entityToModel(answerRepositoryJpa.save(AnswerMapper.modelToEntity(answer)));
    }
}
