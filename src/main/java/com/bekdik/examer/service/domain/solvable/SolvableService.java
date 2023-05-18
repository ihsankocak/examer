package com.bekdik.examer.service.domain.solvable;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SolvableService {
    private QuestionMapper questionMapper;
    private SolvableRepository solvableRepository;

    public SolvableService(QuestionMapper questionMapper, SolvableRepository solvableRepository) {
        this.questionMapper = questionMapper;
        this.solvableRepository = solvableRepository;
    }

    public QuestionDTO createQuestion(QuestionDTO questionDTO) throws Exception{

        QuestionEntity savedQuestionWithId = solvableRepository.save(questionMapper.toEntity(questionDTO));
        return questionMapper.toDTO(savedQuestionWithId);
    }

    public Collection<QuestionDTO> createQuestions(List<QuestionDTO> questionDTOList) throws Exception{

       List<QuestionEntity>  savedQuestionWithId = solvableRepository.saveAll(questionMapper.toEntityList(questionDTOList));
        return questionMapper.toDTOList(savedQuestionWithId);
    }
}
