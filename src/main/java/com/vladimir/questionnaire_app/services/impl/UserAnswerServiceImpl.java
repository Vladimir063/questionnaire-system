package com.vladimir.questionnaire_app.services.impl;

import com.vladimir.questionnaire_app.entity.AnswerEntity;
import com.vladimir.questionnaire_app.entity.UserAnswerEntity;
import com.vladimir.questionnaire_app.entity.UserEntity;
import com.vladimir.questionnaire_app.repository.UserAnswerRepository;
import com.vladimir.questionnaire_app.repository.UserRepository;
import com.vladimir.questionnaire_app.services.UserAnswerService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserAnswerServiceImpl implements UserAnswerService {

    private final UserAnswerRepository userAnswerRepository;
    private final UserDetailServiceImpl userDetailServiceImpl;

    @Override
    public List<UserAnswerEntity> findAll() {
        return userAnswerRepository.findAll();
    }

    @Override
    public UserAnswerEntity findById(Long id) {
        UserAnswerEntity userAnswerEntity = userAnswerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException());

        return userAnswerEntity;
    }
}
