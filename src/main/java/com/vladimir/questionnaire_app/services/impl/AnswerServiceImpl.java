package com.vladimir.questionnaire_app.services.impl;

import com.vladimir.questionnaire_app.dto.AnswerDto;
import com.vladimir.questionnaire_app.entity.AnswerEntity;
import com.vladimir.questionnaire_app.mapper.AnswerMapper;
import com.vladimir.questionnaire_app.repository.AnswerRepository;
import com.vladimir.questionnaire_app.services.AnswerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    @Override
    @Transactional
    public void saveAnswers(List<AnswerDto> answersDto) {
        System.out.println();
        List<AnswerEntity> answerEntities =
                answersDto.stream().map(answerMapper::answerToEntity).collect(Collectors.toList());
        System.out.println();
        answerRepository.saveAll(answerEntities);
    }
}
