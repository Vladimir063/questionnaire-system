package com.vladimir.questionnaire.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AnswerDto {

    private Long id;

    private String name;

    private Long questionId;

    private String questionName;


}
