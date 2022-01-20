package com.vladimir.questionnaire_app.controller;

import com.vladimir.questionnaire_app.dto.AnswerDto;
import com.vladimir.questionnaire_app.dto.QuestionDto;
import com.vladimir.questionnaire_app.services.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("/save-answers")
    public String saveAnswers(@ModelAttribute QuestionDto questionDto) {
        List<AnswerDto> answersDto = questionDto.getAnswersDto();
        System.out.println();
        answerService.saveAnswers(answersDto);
        return "redirect:/index";
    }

}
