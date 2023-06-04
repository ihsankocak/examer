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

    public QuestionDTO createQuestion(QuestionDTO questionDTO) throws Exception {

        Question savedQuestionWithId = solvableRepository.save(questionMapper.toEntity(questionDTO));
        return questionMapper.toDTO(savedQuestionWithId);
    }

    public Collection<QuestionDTO> createQuestions(List<QuestionDTO> questionDTOList) throws Exception {

        List<Question> savedQuestionWithId = solvableRepository.saveAll(questionMapper.toEntityList(questionDTOList));
        return questionMapper.toDTOList(savedQuestionWithId);
    }

    public QuestionDTO getQuestionById(Long questionId) {
        try {
            Question question = solvableRepository.findById(questionId).orElseThrow();
            return questionMapper.toDTO(question);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<QuestionDTO> getQuestionsOfExam() throws Exception {
        return questionMapper.toDTOList(solvableRepository.findAll());
    }
}
