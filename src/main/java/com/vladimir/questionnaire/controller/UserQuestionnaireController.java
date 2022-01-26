package com.vladimir.questionnaire.controller;


import com.vladimir.questionnaire.dto.UserQuestionnaireDto;
import com.vladimir.questionnaire.services.UserQuestionnaireService;
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

    @GetMapping("/all-results")
    public String getAllResults(Model model) {
        log.info("show all results");
        List<UserQuestionnaireDto> userQuestionnaireDtoList = userQuestionnaireService.findAll();
        model.addAttribute("userQuestionnaires", userQuestionnaireDtoList);
        return "all-results";
    }
}
