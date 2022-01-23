package com.vladimir.questionnaire_app.mapper;

import com.vladimir.questionnaire_app.dto.UserAnswerDto;
import com.vladimir.questionnaire_app.entity.UserAnswerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { AnswerMapper.class, UserMapper.class})
public interface UserAnswerMapper {

    @Mapping(target = "userId", source = "userEntity.id")
    @Mapping(target = "userName", source = "userEntity.name")
    UserAnswerDto userAnswerToDto(UserAnswerEntity userAnswerEntity);

    @InheritInverseConfiguration
    UserAnswerEntity userAnswerToEntity(UserAnswerDto userAnswerDto);
}
