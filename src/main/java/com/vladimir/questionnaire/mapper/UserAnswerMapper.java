package com.vladimir.questionnaire.mapper;

import com.vladimir.questionnaire.dto.UserAnswerDto;
import com.vladimir.questionnaire.entity.UserAnswerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { AnswerMapper.class, UserMapper.class})
public interface UserAnswerMapper {

    @Mapping(target = "userId", source = "userEntity.id")
    @Mapping(target = "userName", source = "userEntity.name")
    @Mapping(target = "answerId", source = "answerEntity.id")
    @Mapping(target = "answerName", source = "answerEntity.name")
    @Mapping(target = "questionName", source = "answerEntity.questionEntity.name")
    UserAnswerDto userAnswerToDto(UserAnswerEntity userAnswerEntity);

    @InheritInverseConfiguration
    UserAnswerEntity userAnswerToEntity(UserAnswerDto userAnswerDto);
}
