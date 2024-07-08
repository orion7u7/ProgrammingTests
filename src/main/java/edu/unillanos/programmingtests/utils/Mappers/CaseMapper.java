package edu.unillanos.programmingtests.utils.Mappers;

import edu.unillanos.programmingtests.controllers.request.CaseDTO;
import edu.unillanos.programmingtests.entities.CaseEntity;
import edu.unillanos.programmingtests.entities.ProblemEntity;
import edu.unillanos.programmingtests.models.Case;

import java.util.List;
import java.util.stream.Collectors;

public class CaseMapper {

    public static List<Case> entityListToModelList(List<CaseEntity> caseEntityList) {
        return caseEntityList.stream().map(CaseMapper::entityToModel).collect(Collectors.toList());
    }

    public static Case entityToModel(CaseEntity caseEntity) {
        return new Case(caseEntity.getId(), caseEntity.getInput(), caseEntity.getOutput(), caseEntity.getProblemId().getId());
    }

    public static CaseEntity modelToEntity(Case caseModel) {
        CaseEntity caseEntity = new CaseEntity();
        caseEntity.setId(caseModel.getId());
        caseEntity.setInput(caseModel.getInput());
        caseEntity.setOutput(caseModel.getOutput());

        ProblemEntity problemEntity = new ProblemEntity();

        problemEntity.setId(caseModel.getProblemId());
        caseEntity.setProblemId(problemEntity);

        return caseEntity;
    }

    public static Case dtoToModel(CaseDTO casedto) {
        return new Case(casedto.getId(), casedto.getInput(), casedto.getOutput(), casedto.getProblem());
    }
}
