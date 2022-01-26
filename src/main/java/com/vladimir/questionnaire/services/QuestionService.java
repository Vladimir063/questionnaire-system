package com.vladimir.questionnaire.services;

import com.vladimir.questionnaire.dto.QuestionDto;

public interface QuestionService {
    Long saveOrUpdateQuestion(QuestionDto questionDto);

    QuestionDto findById(Long id);

    void deleteQuestionById(Long id);

    void initListAnswer(QuestionDto questionDto);

    Long updateQuestion(QuestionDto questionDto);
}
