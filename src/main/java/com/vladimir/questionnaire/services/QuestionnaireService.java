package com.vladimir.questionnaire.services;

import com.vladimir.questionnaire.dto.QuestionnaireDto;

import java.util.List;

public interface QuestionnaireService {

    List<QuestionnaireDto> findAll();

    Long saveQuestionnaire(QuestionnaireDto questionnaireDto);

    QuestionnaireDto findById(Long id);

    void deleteQuestionnaireById(Long id);

    Long updateQuestionnaire(QuestionnaireDto questionnaireDto);
}
