package com.vladimir.questionnaire.repository;

import com.vladimir.questionnaire.entity.QuestionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireRepository extends JpaRepository<QuestionnaireEntity, Long> {
}
