package com.vladimir.questionnaire_app.repository;

import com.vladimir.questionnaire_app.entity.QuestionEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionCustomRepository {

    QuestionEntity updateQuestion(QuestionEntity questionEntity);
}
