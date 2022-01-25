package com.vladimir.questionnaire_app.repository;

import com.vladimir.questionnaire_app.dto.AnswerDto;
import com.vladimir.questionnaire_app.dto.QuestionDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerCustomRepository {

    void updateAnswers(List<AnswerDto> answersDto, QuestionDto questionDto);
}
