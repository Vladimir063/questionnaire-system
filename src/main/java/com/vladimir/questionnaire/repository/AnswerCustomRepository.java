package com.vladimir.questionnaire.repository;

import com.vladimir.questionnaire.dto.AnswerDto;
import com.vladimir.questionnaire.dto.QuestionDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerCustomRepository {

    void updateAnswers(List<AnswerDto> answersDto, QuestionDto questionDto);
}
