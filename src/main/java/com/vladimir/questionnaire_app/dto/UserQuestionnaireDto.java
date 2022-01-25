package com.vladimir.questionnaire_app.dto;

import com.vladimir.questionnaire_app.entity.QuestionnaireEntity;
import com.vladimir.questionnaire_app.entity.UserEntity;
import lombok.*;

import javax.persistence.*;

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
