package com.vladimir.questionnaire_app.services;

import com.vladimir.questionnaire_app.dto.QuestionnaireDto;
import com.vladimir.questionnaire_app.entity.QuestionnaireEntity;

import java.util.List;

public interface QuestionnaireService {

    List<QuestionnaireDto> findAll();

    Long saveQuestionnaire(QuestionnaireDto questionnaireDto);

    QuestionnaireDto findById(Long id);

    void deleteQuestionnaireById(Long id);

    Long updateQuestionnaire(QuestionnaireDto questionnaireDto);
}
