package com.vladimir.questionnaire_app.controller;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.vladimir.questionnaire_app.dto.QuestionnaireDto;
import com.vladimir.questionnaire_app.entity.QuestionnaireEntity;
import com.vladimir.questionnaire_app.entity.UserAnswerEntity;
import com.vladimir.questionnaire_app.entity.UserEntity;
import com.vladimir.questionnaire_app.repository.QuestionnaireRepository;
import com.vladimir.questionnaire_app.services.QuestionnaireService;
import com.vladimir.questionnaire_app.services.UserAnswerService;
import com.vladimir.questionnaire_app.services.impl.UserDetailServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;



@Controller
@AllArgsConstructor
public class UserAnswerController {

    private final UserAnswerService userAnswerService;
    private final UserDetailServiceImpl userDetailsService;
    private final QuestionnaireService questionnaireService;


    @GetMapping("/userAnswer/{userId}/{questionnaireId}")
    public String getAnswerOnQuestionForUser(@PathVariable Long userId,
                                             @PathVariable Long questionnaireId, Model model){

        List<UserAnswerEntity> userAnswerEntities = userAnswerService.findByUserAndQuestionnaire(userId, questionnaireId);
        UserEntity userEntity = userDetailsService.findById(userId);
        QuestionnaireDto questionnaireDto = questionnaireService.findById(questionnaireId);
        Map<String, Collection<String>> map = userAnswerService.getAnswerOnQuestion(userAnswerEntities);

        model.addAttribute("questionnaire", questionnaireDto);
        model.addAttribute("map", map);
        model.addAttribute("user", userEntity);

        return "result-questionnaire-for-user";
    }


}
