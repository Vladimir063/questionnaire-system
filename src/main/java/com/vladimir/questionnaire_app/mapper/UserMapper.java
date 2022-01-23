package com.vladimir.questionnaire_app.mapper;

import com.vladimir.questionnaire_app.dto.UserAnswerDto;
import com.vladimir.questionnaire_app.dto.UserDto;
import com.vladimir.questionnaire_app.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { UserAnswerMapper.class})
public interface UserMapper {

    @Mapping(target ="userAnswersDto", source = "userAnswerEntities")
    UserDto userToDto(UserEntity userEntity);

    @Mapping(target ="userQuestionnaireEntities", ignore = true)
    @InheritInverseConfiguration
    UserEntity userToEntity(UserDto userDto);
}
