package com.vladimir.questionnaire.repository;

import com.vladimir.questionnaire.entity.UserQuestionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserQuestionnaireRepository extends JpaRepository<UserQuestionnaireEntity, Long> {

//    @Query("SELECT DISTINCT u.answerEntity.questionEntity.questionnaireEntity.name, u.userEntity.name" +
//            " FROM UserAnswerEntity u ")
//    List<Object> findAll2();

    List<UserQuestionnaireEntity> findAll();
 }
