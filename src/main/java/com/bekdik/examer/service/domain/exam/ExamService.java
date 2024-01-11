package com.bekdik.examer.service.domain.exam;

import com.bekdik.examer.service.domain.solvable.Question;
import com.bekdik.examer.service.domain.solvable.QuestionDTO;
import com.bekdik.examer.service.domain.solvable.QuestionMapper;
import com.bekdik.examer.service.domain.solvable.SolvableRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    public List<ExamDTO> createExamList(List<ExamDTO> examDTOList, String owner) throws Exception {
        List<Exam> examList=examMapper.toEntityList(examDTOList);
        examList=  examRepository.saveAll(examList);
        examList.forEach((exam)->{
            exam.setUsername(owner);
            exam.getQuestions().forEach(e-> e.setExam(exam));
            solvableRepository.saveAll(exam.getQuestions());
       });

        examList=examRepository.saveAll(examList);
        return  examMapper.toDtoList(examList);
    }
@Transactional
    public ExamDTO createExam(ExamDTO examDTO, String owner) throws Exception {
    Exam exam=examMapper.toEntity(examDTO);

     exam.setUsername(owner);
    Exam savedExamWithId = examRepository.save(exam);
    List<Question> questionEntityList=questionMapper.toEntityList(examDTO.getQuestions());
    questionEntityList.stream().forEach(e-> e.setExam(exam));
    solvableRepository.saveAll(questionEntityList);
    exam.setQuestions(questionEntityList);
     savedExamWithId = examRepository.save(exam);
        return examMapper.toDto(savedExamWithId);
    }

    public ExamDTO getExam(long id) throws Exception {
        return examMapper.toDto(examRepository.findById(id).orElseThrow());
    }

    public Collection<ExamDTO> getExamByUsername(String username) throws Exception {
       List<Exam> examsOfUser= examRepository.findByUsername(username).orElseThrow();
        return examMapper.toDtoList(examsOfUser);
    }
}
