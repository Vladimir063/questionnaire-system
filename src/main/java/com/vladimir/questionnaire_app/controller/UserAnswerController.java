package com.vladimir.questionnaire_app.controller;

import com.vladimir.questionnaire_app.entity.UserAnswerEntity;
import com.vladimir.questionnaire_app.services.UserAnswerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserAnswerController {

    private final UserAnswerService userAnswerService;

    @GetMapping("/all-results")
    public String getAllResults(Model model) {
        List<UserAnswerEntity> userAnswerEntities = userAnswerService.findAll();
        model.addAttribute("userAnswerList" , userAnswerEntities);
        return "all-results";
    }

    @GetMapping("/userAnswer/{id}")
    public String getAnswerOnQuestionForUser(@PathVariable Long id, Model model){
        UserAnswerEntity userAnswerEntity = userAnswerService.findById(id);
        model.addAttribute("userAnswer", userAnswerEntity);
        return "result-questionnaire-for-user";
    }
}
