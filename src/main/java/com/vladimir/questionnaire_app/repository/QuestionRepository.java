package com.vladimir.questionnaire_app.repository;

import com.vladimir.questionnaire_app.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository <QuestionEntity, Long> {

}
