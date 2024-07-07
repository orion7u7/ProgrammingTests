package edu.unillanos.programmingtests.services;

import edu.unillanos.programmingtests.models.Case;
import edu.unillanos.programmingtests.repositories.impl.CaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService {

    private final CaseRepository caseRepository;

    public CaseService(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public List<Case> findAll() {
        return caseRepository.findAll();
    }

    public Case findById(Long id) {
        return caseRepository.findById(id);
    }

    public Case save(Case caseModel) {
        return caseRepository.save(caseModel);
    }
}
