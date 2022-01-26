package com.vladimir.questionnaire.mapper;

import com.vladimir.questionnaire.dto.UserQuestionnaireDto;
import com.vladimir.questionnaire.entity.UserQuestionnaireEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { UserMapper.class, QuestionnaireMapper.class})
public interface UserQuestionnaireMapper {

    @Mapping(target = "userId", source = "userEntity.id")
    @Mapping(target = "userName", source = "userEntity.name")
    @Mapping(target = "questionnaireId", source = "questionnaireEntity.id")
    @Mapping(target = "questionnaireName", source = "questionnaireEntity.name")
    UserQuestionnaireDto userQuestionnaireToDto(UserQuestionnaireEntity userQuestionnaireEntity);


}
