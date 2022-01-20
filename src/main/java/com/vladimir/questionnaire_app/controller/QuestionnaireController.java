package com.vladimir.questionnaire_app.controller;

import com.vladimir.questionnaire_app.dto.QuestionDto;
import com.vladimir.questionnaire_app.dto.QuestionnaireDto;
import com.vladimir.questionnaire_app.entity.QuestionnaireEntity;
import com.vladimir.questionnaire_app.services.QuestionnaireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    @GetMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        List<QuestionnaireDto> questionnaireDtoList = questionnaireService.findAll();
        model.addAttribute("questionnaires", questionnaireDtoList);
        return "index";
    }

    @GetMapping("/new-questionnaire")
    public String newQuestionnaire(Model model) {
        QuestionnaireDto questionnaireDto = new QuestionnaireDto();
        model.addAttribute("questionnaire", questionnaireDto);
        return "new-questionnaire";
    }
    
    @PostMapping("/save-questionnaire")
    public String saveQuestionnaire(@ModelAttribute QuestionnaireDto questionnaireDto) {
        Long questionnaireId = questionnaireService.saveQuestionnaire(questionnaireDto);
        return "redirect:/questionnaire/" + questionnaireId ;
    }

    @GetMapping("/questionnaire/{id}")
    public String questionnaireById(@PathVariable Long id, Model model){
        QuestionnaireDto questionnaireDto = questionnaireService.findById(id);
        model.addAttribute("questionnaire", questionnaireDto);
        return "questionnaire";
    }



}
