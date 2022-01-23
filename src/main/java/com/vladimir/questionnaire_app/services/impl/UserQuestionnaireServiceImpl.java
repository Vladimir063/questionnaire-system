package com.vladimir.questionnaire_app.services.impl;

import com.vladimir.questionnaire_app.entity.UserQuestionnaireEntity;
import com.vladimir.questionnaire_app.repository.UserQuestionnaireRepository;
import com.vladimir.questionnaire_app.services.UserQuestionnaireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserQuestionnaireServiceImpl implements UserQuestionnaireService {

    private final UserQuestionnaireRepository userQuestionnaireRepository;


    @Override
    public List<UserQuestionnaireEntity> findAll() {
        return userQuestionnaireRepository.findAll();
    }
}
