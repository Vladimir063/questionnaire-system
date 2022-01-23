package com.vladimir.questionnaire_app.dto;


import com.vladimir.questionnaire_app.entity.AnswerEntity;
import com.vladimir.questionnaire_app.entity.UserEntity;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserAnswerDto {

    private Long id;

    private Long userId;

    private String userName;

    private Long answerId;

    private String answerName;


}
