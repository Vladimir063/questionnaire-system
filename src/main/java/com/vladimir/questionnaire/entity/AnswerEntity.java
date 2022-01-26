package com.vladimir.questionnaire.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"questionEntity"})
@Builder
@Entity
@Table(name = "answers")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionEntity questionEntity;

    @OneToMany(mappedBy = "answerEntity", cascade = CascadeType.ALL)
    private List<UserAnswerEntity> userAnswerEntities = new ArrayList<>();
}
