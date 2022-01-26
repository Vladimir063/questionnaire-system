package com.vladimir.questionnaire.services;

import com.vladimir.questionnaire.dto.UserDto;
import com.vladimir.questionnaire.dto.UserQuestionnaireDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserQuestionnaireService {

    List<UserQuestionnaireDto> findAll();

    void saveResults(UserDto userDto, HttpServletRequest request);
}
