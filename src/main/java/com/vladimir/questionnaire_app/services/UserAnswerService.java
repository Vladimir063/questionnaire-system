package com.vladimir.questionnaire_app.services;


import com.vladimir.questionnaire_app.entity.UserAnswerEntity;

import java.util.List;
import java.util.Optional;

public interface UserAnswerService {

    List<UserAnswerEntity> findAll();

    UserAnswerEntity  findById(Long id);
}
