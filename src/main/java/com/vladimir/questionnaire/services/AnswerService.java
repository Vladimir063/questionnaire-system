package com.vladimir.questionnaire.services;

import com.vladimir.questionnaire.dto.AnswerDto;
import com.vladimir.questionnaire.dto.QuestionDto;

import java.util.List;

public interface AnswerService {
    void saveAnswers(List<AnswerDto> answersDto, QuestionDto questionDto);
}
