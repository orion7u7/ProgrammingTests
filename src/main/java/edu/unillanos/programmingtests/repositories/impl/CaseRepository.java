package edu.unillanos.programmingtests.repositories.impl;

import edu.unillanos.programmingtests.entities.CaseEntity;
import edu.unillanos.programmingtests.models.Case;
import edu.unillanos.programmingtests.repositories.jpa.CaseRepositoryJpa;
import edu.unillanos.programmingtests.utils.Mappers.CaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class CaseRepository {

    private final CaseRepositoryJpa caseRepositoryJpa;

    public List<Case> findAll() {
        return CaseMapper.entityListToModelList(caseRepositoryJpa.findAll());
    }

    public Case findById(Long id) {
        return CaseMapper.entityToModel(Objects.requireNonNull(caseRepositoryJpa.findById(id).orElse(null)));
    }

    public List<Case> findByProblemId(long problemId){
        return CaseMapper.entityListToModelList(caseRepositoryJpa.findByProblemId(problemId));
    }

    public Case save(Case caseModel) {
        return CaseMapper.entityToModel(caseRepositoryJpa.save(CaseMapper.modelToEntity(caseModel)));
    }

}
