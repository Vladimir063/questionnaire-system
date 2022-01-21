package com.vladimir.questionnaire_app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
// @ToString(exclude = {"description","restaurantEntity"})
@Builder
@Entity
@Table(name = "questionnaires")
public class QuestionnaireEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "questionnaireEntity", cascade = CascadeType.ALL)
    private List<QuestionEntity> questionsEntity;

}
