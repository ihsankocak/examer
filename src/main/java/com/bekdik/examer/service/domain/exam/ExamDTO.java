package com.bekdik.examer.service.domain.exam;

import com.bekdik.examer.service.domain.solvable.QuestionDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ExamDTO {

    private Long id;
    private String name;
    private String username;
    List<QuestionDTO> questions;
}
