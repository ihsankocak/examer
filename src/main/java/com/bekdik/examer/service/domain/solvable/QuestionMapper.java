package com.bekdik.examer.service.domain.solvable;

import org.mapstruct.Mapper;
import java.util.Collection;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionDTO toDTO(Question source)throws Exception;
    Question toEntity(QuestionDTO destination) throws Exception;

    Collection<QuestionDTO>  toDTOList(Collection<Question> questionList) throws Exception;
    Collection<Question> toEntityList(Collection<QuestionDTO> questionList)throws Exception;
}

