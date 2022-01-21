package com.vladimir.questionnaire_app.repository;

import com.vladimir.questionnaire_app.entity.QuestionnaireEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireCustomRepository {

    QuestionnaireEntity updateQuestionnaire(QuestionnaireEntity questionnaireEntity);
}
