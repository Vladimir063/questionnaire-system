package com.vladimir.questionnaire.repository;

import com.vladimir.questionnaire.entity.AnswerEntity;
import com.vladimir.questionnaire.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {

    void deleteAllByQuestionEntity(QuestionEntity questionEntity);
}
