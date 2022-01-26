package com.vladimir.questionnaire.services.impl;

import com.vladimir.questionnaire.dto.AnswerDto;
import com.vladimir.questionnaire.dto.QuestionDto;
import com.vladimir.questionnaire.entity.AnswerEntity;
import com.vladimir.questionnaire.entity.QuestionEntity;
import com.vladimir.questionnaire.mapper.AnswerMapper;
import com.vladimir.questionnaire.mapper.QuestionMapper;
import com.vladimir.questionnaire.repository.AnswerRepository;
import com.vladimir.questionnaire.services.AnswerService;
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
    private final QuestionMapper questionMapper;

    @Override
    @Transactional
    public void saveAnswers(List<AnswerDto> answersDto, QuestionDto questionDto) {
        deleteOldList(questionDto);
        List<AnswerEntity> answerEntities =
                answersDto.stream().map(answerMapper::answerToEntity).collect(Collectors.toList());
        answerRepository.saveAll(answerEntities);
    }

    @Transactional
    public void deleteOldList(QuestionDto questionDto){
        List<AnswerDto> answersDto = questionDto.getAnswersDto();
        QuestionEntity questionEntity = questionMapper.questionToEntity(questionDto);
        answerRepository.deleteAllByQuestionEntity(questionEntity);
    }
}
