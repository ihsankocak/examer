package com.bekdik.examer.service.domain.solvable;

import com.bekdik.examer.application.BaseMapper;
import org.mapstruct.Mapper;
import java.util.Collection;

@Mapper(componentModel = "spring")
public interface QuestionMapper extends BaseMapper<Question,QuestionDTO> {
//    QuestionDTO toDTO(Question source)throws Exception;
//    Question toEntity(QuestionDTO destination) throws Exception;
//
//    Collection<QuestionDTO>  toDTOList(Collection<Question> questionList) throws Exception;
//    Collection<Question> toEntityList(Collection<QuestionDTO> questionList)throws Exception;
}

