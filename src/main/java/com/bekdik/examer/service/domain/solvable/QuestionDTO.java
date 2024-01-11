package com.bekdik.examer.service.domain.solvable;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class QuestionDTO {
    private Long id;
    private String problem;
    private String solution;
    private List<String> choices;


}
