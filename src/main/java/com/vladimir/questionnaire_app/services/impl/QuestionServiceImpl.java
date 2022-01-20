package com.vladimir.questionnaire_app.services.impl;

import com.vladimir.questionnaire_app.dto.QuestionDto;
import com.vladimir.questionnaire_app.entity.QuestionEntity;
import com.vladimir.questionnaire_app.exception.QuestionNotFoundException;
import com.vladimir.questionnaire_app.exception.QuestionnaireNotFoundException;
import com.vladimir.questionnaire_app.mapper.QuestionMapper;
import com.vladimir.questionnaire_app.repository.QuestionRepository;
import com.vladimir.questionnaire_app.services.QuestionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionMapper questionMapper;
    private final QuestionRepository questionRepository;

    @Override
    public Long saveQuestion(QuestionDto questionDto) {
        QuestionEntity questionEntity = questionMapper.questionToEntity(questionDto);
        QuestionEntity questionEntitySave = questionRepository.save(questionEntity);
        return questionEntitySave.getId();
    }

    @Override
    public QuestionDto findById(Long id) {
        QuestionEntity questionEntity = questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found by id = " + id));
        return questionMapper.questionToDto(questionEntity);
    }
}
