package com.vladimir.questionnaire_app.entity;

import com.vladimir.questionnaire_app.entity.enums.Status;
import com.vladimir.questionnaire_app.security.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status status;
//
//    @ManyToMany
//    private List<QuestionnaireEntity> questionnaireEntities;
//
//    @ManyToMany
//    private List<AnswerEntity> answers;

    @OneToMany(mappedBy = "userEntity")
    private List<UserQuestionnaireEntity> userQuestionnaireEntities = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity")
    private List<UserAnswerEntity> userAnswerEntities = new ArrayList<>();
}
