package com.vladimir.questionnaire_app.controller;


import com.vladimir.questionnaire_app.entity.UserEntity;
import com.vladimir.questionnaire_app.entity.UserQuestionnaireEntity;
import com.vladimir.questionnaire_app.services.UserQuestionnaireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserQuestionnaireController {

    private  final UserQuestionnaireService userQuestionnaireService;

//    @GetMapping("/all-results")
//    public String getAllResults(Model model) {
//        List<UserEntity> userEntities = userDetailsService.findAll();
//        model.addAttribute("userEntities", userEntities);
//
//        return "all-results";
//    }

    @GetMapping("/all-results")
    public String getAllResults(Model model) {
        List<UserQuestionnaireEntity> userQuestionnaireEntities = userQuestionnaireService.findAll();
        model.addAttribute("userQuestionnaires", userQuestionnaireEntities);
        return "all-results";
    }
}
