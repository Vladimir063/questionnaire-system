package com.vladimir.questionnaire_app.repository;

import com.vladimir.questionnaire_app.entity.UserAnswerEntity;
import com.vladimir.questionnaire_app.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAnswerRepository  extends JpaRepository<UserAnswerEntity, Long> {

    List<UserAnswerEntity> findUserAnswerEntitiesByUserEntity(UserEntity userEntity);
}
