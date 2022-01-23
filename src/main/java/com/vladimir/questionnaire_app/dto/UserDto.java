package com.vladimir.questionnaire_app.dto;

import com.vladimir.questionnaire_app.entity.UserAnswerEntity;
import com.vladimir.questionnaire_app.entity.UserQuestionnaireEntity;
import com.vladimir.questionnaire_app.entity.enums.Status;
import com.vladimir.questionnaire_app.security.Role;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto {

    private Long id;

    private String email;

    private String password;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private Status status;

  //  private List<UserQuestionnaire> userQuestionnaireEntities = new ArrayList<>();

    private List<UserAnswerDto> userAnswersDto = new ArrayList<>();
}
