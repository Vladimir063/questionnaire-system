package com.vladimir.questionnaire_app.services;

import com.vladimir.questionnaire_app.dto.QuestionDto;

public interface QuestionService {
    Long saveQuestion(QuestionDto questionDto);

    QuestionDto findById(Long id);

    void deleteQuestionById(Long id);

    Long updateQuestion(QuestionDto questionDto);
}
