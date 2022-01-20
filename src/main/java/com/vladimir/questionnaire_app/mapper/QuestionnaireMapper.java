package com.vladimir.questionnaire_app.mapper;

import com.vladimir.questionnaire_app.dto.QuestionnaireDto;
import com.vladimir.questionnaire_app.entity.QuestionnaireEntity;
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
