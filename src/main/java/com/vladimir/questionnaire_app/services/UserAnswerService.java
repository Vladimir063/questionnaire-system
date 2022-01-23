package com.vladimir.questionnaire_app.services;


import com.google.common.collect.HashMultimap;
import com.vladimir.questionnaire_app.entity.UserAnswerEntity;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserAnswerService {

    List<UserAnswerEntity> findAll();

    List<UserAnswerEntity> findAll2();

    UserAnswerEntity  findById(Long id);

    List<UserAnswerEntity> findByUserAndQuestionnaire(Long userId, Long questionnaireId);

    Map<String, Collection<String>> getAnswerOnQuestion(List<UserAnswerEntity> userAnswerEntities);
}
