package com.vladimir.questionnaire.mapper;

import com.vladimir.questionnaire.dto.QuestionDto;
import com.vladimir.questionnaire.entity.QuestionEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { QuestionnaireMapper.class, AnswerMapper.class })
public interface QuestionMapper {

    @Mapping(target = "questionnaireId", source = "questionnaireEntity.id")
    @Mapping(target = "questionnaireName", source = "questionnaireEntity.name")
    @Mapping(target = "answersDto", source = "answersEntity")
    QuestionDto questionToDto(QuestionEntity questionEntity);

    @InheritInverseConfiguration
    QuestionEntity questionToEntity(QuestionDto questionDto);
}
