package com.vladimir.questionnaire_app.services;

import com.vladimir.questionnaire_app.dto.AnswerDto;
import com.vladimir.questionnaire_app.dto.QuestionDto;

import java.util.List;

public interface AnswerService {
    void saveAnswers(List<AnswerDto> answersDto, QuestionDto questionDto);
}
