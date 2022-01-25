package com.vladimir.questionnaire_app.controller;


import com.vladimir.questionnaire_app.dto.UserQuestionnaireDto;
import com.vladimir.questionnaire_app.entity.UserEntity;
import com.vladimir.questionnaire_app.entity.UserQuestionnaireEntity;
import com.vladimir.questionnaire_app.services.UserQuestionnaireService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
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
        log.info("show all results");
        List<UserQuestionnaireDto> userQuestionnaireDtoList = userQuestionnaireService.findAll();
        System.out.println();
        model.addAttribute("userQuestionnaires", userQuestionnaireDtoList);
        return "all-results";
    }
}
