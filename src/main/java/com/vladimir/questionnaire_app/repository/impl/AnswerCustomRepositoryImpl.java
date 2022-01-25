package com.vladimir.questionnaire_app.repository.impl;

import com.vladimir.questionnaire_app.dto.AnswerDto;
import com.vladimir.questionnaire_app.dto.QuestionDto;
import com.vladimir.questionnaire_app.entity.AnswerEntity;
import com.vladimir.questionnaire_app.mapper.AnswerMapper;
import com.vladimir.questionnaire_app.repository.AnswerCustomRepository;
import com.vladimir.questionnaire_app.services.AnswerService;
import com.vladimir.questionnaire_app.services.impl.AnswerServiceImpl;
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
