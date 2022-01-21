package com.vladimir.questionnaire_app.repository.impl;

import com.vladimir.questionnaire_app.entity.QuestionEntity;
import com.vladimir.questionnaire_app.repository.QuestionCustomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@AllArgsConstructor
public class QuestionCustomRepositoryImpl implements QuestionCustomRepository {

    private final EntityManager entityManager;

    @Override
    public QuestionEntity updateQuestion(QuestionEntity questionEntity) {
        return entityManager.merge(questionEntity);
    }
}
