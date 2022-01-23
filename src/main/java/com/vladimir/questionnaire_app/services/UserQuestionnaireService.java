package com.vladimir.questionnaire_app.services;

import com.vladimir.questionnaire_app.entity.UserQuestionnaireEntity;

import java.util.List;

public interface UserQuestionnaireService {

    List<UserQuestionnaireEntity> findAll();
}
