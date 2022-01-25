package com.vladimir.questionnaire_app.services;


import com.google.common.collect.HashMultimap;
import com.vladimir.questionnaire_app.dto.UserAnswerDto;
import com.vladimir.questionnaire_app.entity.UserAnswerEntity;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserAnswerService {

    List<UserAnswerDto> findAll();

    // List<UserAnswerDto> findAll2();

    UserAnswerDto  findById(Long id);

    List<UserAnswerDto> findByUserAndQuestionnaire(Long userId, Long questionnaireId);

    Map<String, Collection<String>> getAnswerOnQuestion(List<UserAnswerDto> userAnswerEntities);
}
