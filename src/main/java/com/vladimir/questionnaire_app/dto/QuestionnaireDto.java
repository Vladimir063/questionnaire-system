package com.vladimir.questionnaire_app.dto;

import com.vladimir.questionnaire_app.entity.QuestionEntity;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class QuestionnaireDto {

    private Long id;

    private String name;

    private List<QuestionDto> questionsDto;
}
