package com.vladimir.questionnaire.controller;

import com.vladimir.questionnaire.dto.QuestionnaireDto;
import com.vladimir.questionnaire.dto.UserAnswerDto;
import com.vladimir.questionnaire.dto.UserDto;
import com.vladimir.questionnaire.services.QuestionnaireService;
import com.vladimir.questionnaire.services.UserAnswerService;
import com.vladimir.questionnaire.services.impl.UserDetailServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;


@Slf4j
@Controller
@AllArgsConstructor
public class UserAnswerController {

    private final UserAnswerService userAnswerService;
    private final UserDetailServiceImpl userDetailsService;
    private final QuestionnaireService questionnaireService;

    @GetMapping("/userAnswer/{userId}/{questionnaireId}")
    public String getAnswerOnQuestionForUser(@PathVariable Long userId,            // ищем заполненные анкеты для юзеров
                                             @PathVariable Long questionnaireId, Model model){

        List<UserAnswerDto> userAnswerDtos = userAnswerService.findByUserAndQuestionnaire(userId, questionnaireId);
        UserDto userDto = userDetailsService.findById(userId);
        QuestionnaireDto questionnaireDto = questionnaireService.findById(questionnaireId);
        Map<String, Collection<String>> map = userAnswerService.getAnswerOnQuestion(userAnswerDtos);

        model.addAttribute("questionnaire", questionnaireDto);
        model.addAttribute("map", map);
        model.addAttribute("user", userDto);
        log.info("show answer on question for user {}", userDto.getName());
        return "result-questionnaire-for-user";
    }
}
