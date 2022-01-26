package com.vladimir.questionnaire.dto;


import lombok.*;

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

    private String questionName;


}
