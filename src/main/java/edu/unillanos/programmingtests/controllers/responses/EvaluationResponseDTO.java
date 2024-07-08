package edu.unillanos.programmingtests.controllers.responses;

import edu.unillanos.programmingtests.controllers.request.ProblemDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EvaluationResponseDTO {
    private Long id;
    private String name;
    private String date;
    private List<ProblemDTO> problems;

}
