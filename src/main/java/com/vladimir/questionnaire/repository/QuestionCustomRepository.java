package com.vladimir.questionnaire.repository;

import com.vladimir.questionnaire.entity.QuestionEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionCustomRepository {

    QuestionEntity updateQuestion(QuestionEntity questionEntity);
}
