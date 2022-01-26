package com.vladimir.questionnaire.repository;

import com.vladimir.questionnaire.entity.QuestionnaireEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireCustomRepository {

    QuestionnaireEntity updateQuestionnaire(QuestionnaireEntity questionnaireEntity);
}
