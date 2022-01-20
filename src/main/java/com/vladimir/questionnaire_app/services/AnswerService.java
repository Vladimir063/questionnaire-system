package com.vladimir.questionnaire_app.services;

import com.vladimir.questionnaire_app.dto.AnswerDto;

import java.util.List;

public interface AnswerService {
    void saveAnswers(List<AnswerDto> answersDto);
}
