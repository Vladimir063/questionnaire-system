package com.vladimir.questionnaire.controller;

import com.vladimir.questionnaire.dto.AnswerDto;
import com.vladimir.questionnaire.dto.QuestionDto;
import com.vladimir.questionnaire.services.AnswerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("/save-answers")
    public String saveAnswers(@ModelAttribute QuestionDto questionDto) {
        System.out.println();
        List<AnswerDto> answersDto = questionDto.getAnswersDto();
        log.info("save  {}", answersDto);
        answerService.saveAnswers(answersDto, questionDto);
        return "redirect:/questionnaire/" + questionDto.getQuestionnaireId();
    }
}
