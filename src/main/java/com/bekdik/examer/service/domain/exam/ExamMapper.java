package com.bekdik.examer.service.domain.exam;

import org.mapstruct.Mapper;


import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ExamMapper {
    ExamDTO toDTO(Exam source)throws Exception;
    Exam toEntity(ExamDTO destination) throws Exception;

    Collection<ExamDTO>  toDTOList(Collection<Exam> questionList) throws Exception;
    Collection<Exam> toEntityList(Collection<ExamDTO> questionList)throws Exception;
}

