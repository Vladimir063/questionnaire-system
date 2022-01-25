package com.vladimir.questionnaire_app.dto;

import com.vladimir.questionnaire_app.entity.QuestionEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AnswerDto {

    private Long id;

    private String name;

    private Long questionId;

    private String questionName;


}
