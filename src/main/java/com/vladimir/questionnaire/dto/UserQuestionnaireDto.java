package com.vladimir.questionnaire.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserQuestionnaireDto {

    private Long id;

    private Long userId;

    private String userName;

    private String  questionnaireId;

    private String questionnaireName;
}
