package com.bekdik.examer.service.domain.solvable;

import com.bekdik.examer.service.domain.exam.ExamDTO;
import com.bekdik.examer.service.domain.exam.ExamMapper;
import com.bekdik.examer.service.domain.exam.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SolvableService {
    private ExamMapper examMapper;
    private QuestionMapper questionMapper;
    private SolvableRepository solvableRepository;
    private ExamRepository examRepository;

    public SolvableService(SolvableRepository solvableRepository,
                           QuestionMapper questionMapper) {
        this.examMapper = examMapper;
        this.solvableRepository = solvableRepository;
        this.questionMapper = questionMapper;
        this.examRepository = examRepository;
    }

    public QuestionDTO createQuestion(QuestionDTO questionDTO) throws Exception {

        Question savedQuestionWithId = solvableRepository.save(questionMapper.toEntity(questionDTO));
        return questionMapper.toDto(savedQuestionWithId);
    }

    public Collection<QuestionDTO> createQuestions(List<QuestionDTO> questionDTOList) throws Exception {

        List<Question> savedQuestionWithId = solvableRepository.saveAll(questionMapper.toEntityList(questionDTOList));
        return questionMapper.toDtoList(savedQuestionWithId);
    }

    public QuestionDTO getQuestionById(Long questionId) {
        try {
            Question question = solvableRepository.findById(questionId).orElseThrow();
            return questionMapper.toDto(question);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
