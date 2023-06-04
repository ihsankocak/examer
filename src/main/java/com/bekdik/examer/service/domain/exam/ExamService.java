package com.bekdik.examer.service.domain.exam;

import org.springframework.stereotype.Service;

@Service
public class ExamService {
    private ExamMapper examMapper;
    private ExamRepository examRepository;

    public ExamService(ExamMapper examMapper, ExamRepository examRepository) {
        this.examMapper = examMapper;
        this.examRepository = examRepository;
    }

    public ExamDTO createExam(ExamDTO examDTO) throws Exception {

        Exam savedExamWithId = examRepository.save(examMapper.toEntity(examDTO));
        return examMapper.toDTO(savedExamWithId);
    }


}
