package com.vladimir.questionnaire.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class QuestionDto {

    private Long id;

    @NotBlank(message = "Введите название вопроса")
    private String name;

    private Integer countAnswer;

    private Long questionnaireId;

    private String questionnaireName;

    private List<AnswerDto> answersDto;

    public void addAnswer(AnswerDto answerDto) {
        this.answersDto.add(answerDto);
    }
}
