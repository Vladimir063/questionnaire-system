package com.vladimir.questionnaire_app.controller;

import com.vladimir.questionnaire_app.dto.AnswerDto;
import com.vladimir.questionnaire_app.dto.QuestionDto;
import com.vladimir.questionnaire_app.services.AnswerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class AnswerController {

    private final AnswerService answerService;


    @PostMapping("/save-answers")
    public String saveAnswers(@Valid  @ModelAttribute() QuestionDto questionDto) {
        List<AnswerDto> answersDto = questionDto.getAnswersDto();
        log.info("save  {}", answersDto);
        answerService.saveAnswers(answersDto, questionDto);
        return "redirect:/questionnaire/" + questionDto.getQuestionnaireId();
    }


}
