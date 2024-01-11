package com.bekdik.examer.service.domain.exam;

import com.bekdik.examer.application.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ExamMapper  extends BaseMapper<Exam,ExamDTO> {
    ExamMapper INSTANCE = Mappers.getMapper(ExamMapper.class);
}

