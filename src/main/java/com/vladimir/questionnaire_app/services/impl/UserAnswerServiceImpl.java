package com.vladimir.questionnaire_app.services.impl;

import com.google.common.collect.HashMultimap;
import com.vladimir.questionnaire_app.dto.UserAnswerDto;
import com.vladimir.questionnaire_app.entity.AnswerEntity;
import com.vladimir.questionnaire_app.entity.UserAnswerEntity;
import com.vladimir.questionnaire_app.entity.UserEntity;
import com.vladimir.questionnaire_app.exception.UserAnswerNotFoundException;
import com.vladimir.questionnaire_app.mapper.UserAnswerMapper;
import com.vladimir.questionnaire_app.repository.UserAnswerRepository;
import com.vladimir.questionnaire_app.repository.UserRepository;
import com.vladimir.questionnaire_app.services.UserAnswerService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserAnswerServiceImpl implements UserAnswerService {

    private final UserAnswerRepository userAnswerRepository;
    private final UserAnswerMapper userAnswerMapper;

    @Override
    public List<UserAnswerDto> findAll() {
        List<UserAnswerEntity> userAnswerEntities = userAnswerRepository.findAll();
        return userAnswerEntities.stream().map(userAnswerMapper::userAnswerToDto).collect(Collectors.toList());
    }


    @Override
    public UserAnswerDto findById(Long id) {
        UserAnswerEntity userAnswerEntity = userAnswerRepository.findById(id)
                .orElseThrow(() -> new UserAnswerNotFoundException("userAnswerEntity not found by id = " + id));
        return userAnswerMapper.userAnswerToDto(userAnswerEntity);
    }

    @Override
    public List<UserAnswerDto> findByUserAndQuestionnaire(Long userId, Long questionnaireId) {  // ищем заполненные анкеты для юзеров
        List<UserAnswerEntity> userAnswerEntities = userAnswerRepository.findByUserIdAndQuestionnaireId(userId, questionnaireId);
        return userAnswerEntities.stream().map(userAnswerMapper::userAnswerToDto).collect(Collectors.toList());
    }

    @Override
    public Map<String, Collection<String>> getAnswerOnQuestion(List<UserAnswerDto> userAnswerDtos) {
        HashMultimap<String, String> map = HashMultimap.create();
        for (UserAnswerDto u : userAnswerDtos) {
            String key = u.getQuestionName();
            String value = u.getAnswerName();
            map.put(key, value);
        }
        return map.asMap();
    }
}
