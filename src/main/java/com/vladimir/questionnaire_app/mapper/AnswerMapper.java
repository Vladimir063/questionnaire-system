package com.vladimir.questionnaire_app.mapper;

import com.vladimir.questionnaire_app.dto.AnswerDto;
import com.vladimir.questionnaire_app.entity.AnswerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { QuestionMapper.class })
public interface AnswerMapper {

    @Mapping(target = "questionId" , source = "questionEntity.id")
    @Mapping(target = "questionName" , source = "questionEntity.name")
    AnswerDto answerToDto(AnswerEntity answerEntity);

    @InheritInverseConfiguration
    AnswerEntity answerToEntity(AnswerDto answerDto);
}
