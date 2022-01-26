package com.vladimir.questionnaire.services;


import com.vladimir.questionnaire.dto.UserAnswerDto;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface UserAnswerService {

    List<UserAnswerDto> findAll();

    UserAnswerDto  findById(Long id);

    List<UserAnswerDto> findByUserAndQuestionnaire(Long userId, Long questionnaireId);

    Map<String, Collection<String>> getAnswerOnQuestion(List<UserAnswerDto> userAnswerEntities);
}
