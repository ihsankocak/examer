package com.bekdik.examer.service.domain.exam;

import com.bekdik.examer.service.domain.solvable.Question;
import com.bekdik.examer.service.domain.solvable.QuestionDTO;
import com.bekdik.examer.service.domain.solvable.QuestionMapper;
import com.bekdik.examer.service.domain.solvable.SolvableRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExamService {
    private ExamMapper examMapper;
    private ExamRepository examRepository;
    private QuestionMapper questionMapper;
    private SolvableRepository solvableRepository;


    public ExamService(ExamMapper examMapper, ExamRepository examRepository,QuestionMapper questionMapper,SolvableRepository solvableRepository) {
        this.examMapper = examMapper;
        this.examRepository = examRepository;
        this.questionMapper=questionMapper;
        this.solvableRepository=solvableRepository;
    }
@Transactional
    public ExamDTO createExam(Collection<QuestionDTO> questionList, String owner) throws Exception {
    Exam exam=new Exam();
    exam.setUsername(owner);
    Exam savedExamWithId = examRepository.save(exam);
    Collection<Question> questionEntityList=questionMapper.toEntityList(questionList);
    questionEntityList.stream().forEach(e-> e.setExam(exam));
    solvableRepository.saveAll(questionEntityList);
    exam.setQuestionDTOList(questionEntityList);
     savedExamWithId = examRepository.save(exam);
        return examMapper.toDTO(savedExamWithId);
    }


}
