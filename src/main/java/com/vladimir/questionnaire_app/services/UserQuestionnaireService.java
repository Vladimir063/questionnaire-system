package com.vladimir.questionnaire_app.services;

import com.vladimir.questionnaire_app.dto.UserDto;
import com.vladimir.questionnaire_app.dto.UserQuestionnaireDto;
import com.vladimir.questionnaire_app.entity.UserQuestionnaireEntity;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

public interface UserQuestionnaireService {

    List<UserQuestionnaireDto> findAll();

    void saveResults(UserDto userDto, HttpServletRequest request);
}
