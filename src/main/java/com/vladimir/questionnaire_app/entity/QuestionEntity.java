package com.vladimir.questionnaire_app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"questionnaireEntity"})
@Builder
@Entity
@Table(name = "questions")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "count_answer")
    private Integer countAnswer;

    @ManyToOne
    @JoinColumn(name = "questionnaire_id")
    private QuestionnaireEntity questionnaireEntity;

    @OneToMany(mappedBy = "questionEntity")
    private List<AnswerEntity> answersEntity;

}
