package com.vladimir.questionnaire.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class QuestionnaireDto {


    private Long id;

    @NotEmpty(message = "Введите название анкеты")
    private String name;

    private List<QuestionDto> questionsDto;
}
