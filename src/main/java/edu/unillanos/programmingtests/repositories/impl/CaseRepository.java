package edu.unillanos.programmingtests.repositories.impl;

import edu.unillanos.programmingtests.models.Case;
import edu.unillanos.programmingtests.repositories.jpa.CaseRepositoryJpa;
import edu.unillanos.programmingtests.utils.Mappers.CaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CaseRepository {

    private final CaseRepositoryJpa caseRepositoryJpa;

    public List<Case> findAll() {
        return CaseMapper.entityListToModelList(caseRepositoryJpa.findAll());
    }

    public Case findById(Long id) {
        return CaseMapper.entityToModel(caseRepositoryJpa.findById(id).orElse(null));
    }

    public Case save(Case caseModel) {
        return CaseMapper.entityToModel(caseRepositoryJpa.save(CaseMapper.modelToEntity(caseModel)));
    }

}
