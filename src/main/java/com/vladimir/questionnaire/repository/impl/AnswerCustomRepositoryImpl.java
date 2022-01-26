package com.vladimir.questionnaire.repository.impl;

import com.vladimir.questionnaire.dto.AnswerDto;
import com.vladimir.questionnaire.dto.QuestionDto;
import com.vladimir.questionnaire.entity.AnswerEntity;
import com.vladimir.questionnaire.mapper.AnswerMapper;
import com.vladimir.questionnaire.repository.AnswerCustomRepository;
import com.vladimir.questionnaire.services.impl.AnswerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class AnswerCustomRepositoryImpl implements AnswerCustomRepository {

    private final EntityManager entityManager;
    private final AnswerServiceImpl answerServiceImpl;
    private final AnswerMapper answerMapper;

    @Override
    public void updateAnswers(List<AnswerDto> answersDto, QuestionDto questionDto) {
        answerServiceImpl.deleteOldList(questionDto);
        List<AnswerEntity> answerEntities =
                answersDto.stream().map(answerMapper::answerToEntity).collect(Collectors.toList());

        answerEntities.stream().forEach(entityManager::merge);
    }
}
