package com.vladimir.questionnaire_app.repository.impl;


import com.vladimir.questionnaire_app.entity.QuestionnaireEntity;
import com.vladimir.questionnaire_app.repository.QuestionnaireCustomRepository;
import com.vladimir.questionnaire_app.repository.QuestionnaireRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@AllArgsConstructor
public class QuestionnaireCustomRepositoryImpl implements QuestionnaireCustomRepository {

    private final EntityManager entityManager;

    @Override
    public QuestionnaireEntity updateQuestionnaire(QuestionnaireEntity questionnaireEntity) {
        return entityManager.merge(questionnaireEntity);
    }
}
