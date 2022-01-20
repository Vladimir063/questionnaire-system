package com.vladimir.questionnaire_app.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class QuestionDto {

    private Long id;

    private String name;

    private Integer countAnswer;

    private Long questionnaireId;

    private String questionnaireName;

    private List<AnswerDto> answersDto;

    public void addAnswer(AnswerDto answerDto) {
        this.answersDto.add(answerDto);
    }
}