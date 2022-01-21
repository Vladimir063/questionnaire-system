package com.vladimir.questionnaire_app.dto;

import com.vladimir.questionnaire_app.entity.QuestionEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;
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
