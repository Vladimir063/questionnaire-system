package com.vladimir.questionnaire.dto;

import com.vladimir.questionnaire.entity.enums.Status;
import com.vladimir.questionnaire.security.Role;
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

    private List<UserAnswerDto> userAnswersDto = new ArrayList<>();
}
