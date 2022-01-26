package com.vladimir.questionnaire.repository.impl;


import com.vladimir.questionnaire.entity.QuestionnaireEntity;
import com.vladimir.questionnaire.repository.QuestionnaireCustomRepository;
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
