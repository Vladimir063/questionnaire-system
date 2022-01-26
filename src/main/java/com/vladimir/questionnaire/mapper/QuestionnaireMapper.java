package com.vladimir.questionnaire.mapper;

import com.vladimir.questionnaire.dto.QuestionnaireDto;
import com.vladimir.questionnaire.entity.QuestionnaireEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { QuestionMapper.class })
public interface QuestionnaireMapper {

    @Mapping(target = "questionsDto", source = "questionsEntity")
    QuestionnaireDto questionnaireToDto(QuestionnaireEntity questionnaireEntity);

    @InheritInverseConfiguration
    QuestionnaireEntity questionnaireToEntity(QuestionnaireDto questionnaireDto);
}
