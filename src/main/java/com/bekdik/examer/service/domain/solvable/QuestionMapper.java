package com.bekdik.examer.service.domain.solvable;

import org.mapstruct.Mapper;
import java.util.Collection;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionDTO toDTO(QuestionEntity source)throws Exception;
    QuestionEntity toEntity(QuestionDTO destination) throws Exception;

    Collection<QuestionDTO>  toDTOList(Collection<QuestionEntity> questionEntityList) throws Exception;
    Collection<QuestionEntity> toEntityList(Collection<QuestionDTO> questionEntityList)throws Exception;
}

