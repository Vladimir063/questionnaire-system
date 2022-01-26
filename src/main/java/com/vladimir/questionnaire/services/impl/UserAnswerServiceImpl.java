package com.vladimir.questionnaire.services.impl;

import com.google.common.collect.HashMultimap;
import com.vladimir.questionnaire.dto.UserAnswerDto;
import com.vladimir.questionnaire.entity.UserAnswerEntity;
import com.vladimir.questionnaire.exception.UserAnswerNotFoundException;
import com.vladimir.questionnaire.mapper.UserAnswerMapper;
import com.vladimir.questionnaire.repository.UserAnswerRepository;
import com.vladimir.questionnaire.services.UserAnswerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
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
