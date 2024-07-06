package edu.unillanos.programmingtests.services;

import edu.unillanos.programmingtests.models.Problem;
import edu.unillanos.programmingtests.repositories.impl.ProblemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemService {

    private final ProblemRepository problemRepository;

    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public List<Problem> findAll() {
        return problemRepository.findAll();
    }

    public Problem findById(Long id) {
        return problemRepository.findById(id);
    }

    public Problem save(Problem problem) {
        return problemRepository.save(problem);
    }
}
