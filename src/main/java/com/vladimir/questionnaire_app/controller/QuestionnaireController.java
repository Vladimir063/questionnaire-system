package com.vladimir.questionnaire_app.controller;

import com.vladimir.questionnaire_app.dto.*;
import com.vladimir.questionnaire_app.entity.*;
import com.vladimir.questionnaire_app.mapper.AnswerMapper;
import com.vladimir.questionnaire_app.mapper.UserAnswerMapper;
import com.vladimir.questionnaire_app.mapper.UserMapper;
import com.vladimir.questionnaire_app.repository.AnswerRepository;
import com.vladimir.questionnaire_app.repository.UserAnswerRepository;
import com.vladimir.questionnaire_app.repository.UserQuestionnaireRepository;
import com.vladimir.questionnaire_app.repository.UserRepository;
import com.vladimir.questionnaire_app.services.QuestionnaireService;
import com.vladimir.questionnaire_app.services.UserQuestionnaireService;
import com.vladimir.questionnaire_app.services.impl.UserDetailServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.*;

@Slf4j
@Controller
@AllArgsConstructor
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;
    private final UserDetailServiceImpl userDetailsServiceImpl;
    private final UserAnswerRepository userAnswerRepository;
    private final AnswerRepository answerRepository;
    private final UserQuestionnaireRepository userQuestionnaireRepository;
    private final UserMapper userMapper;
    private final AnswerMapper answerMapper;
    private final UserQuestionnaireService userDetailsService;

    @GetMapping({"/", "/index"})
    public String getIndexPage(Model model, Principal principal){
        List<QuestionnaireDto> questionnaireDtoList = questionnaireService.findAll();
        model.addAttribute("questionnaires", questionnaireDtoList);
        return "index";
    }

    @GetMapping("/new-questionnaire")
    public String newQuestionnaire(Model model) {
        log.info("start add new questionnaire");
        QuestionnaireDto questionnaireDto = new QuestionnaireDto();
        model.addAttribute("questionnaire", questionnaireDto);
        return "new-questionnaire";
    }
    
    @PostMapping("/save-questionnaire")
    public String saveQuestionnaire(@Valid @ModelAttribute("questionnaire") QuestionnaireDto questionnaireDto, BindingResult result) {
        if (result.hasErrors()) {
            log.info("error validation when user saved questionnaire");
            return "new-questionnaire";
        }
        Long questionnaireId = questionnaireService.saveQuestionnaire(questionnaireDto);
        log.info("save questionnaire {}" , questionnaireDto.getName());
        return "redirect:/questionnaire/" + questionnaireId ;
    }

    @GetMapping("/edit-questionnaire/{id}")
    public String editQuestionnaire(@PathVariable Long id, Model model) {
        QuestionnaireDto questionnaireDto = questionnaireService.findById(id);
        model.addAttribute("questionnaire", questionnaireDto);
        log.info("edit questionnaire {}" , questionnaireDto.getName());
        return "edit-questionnaire";
    }

    @PostMapping("/update-questionnaire")
    public String updateQuestionnaire(@ModelAttribute QuestionnaireDto questionnaireDto) {
        Long questionnaireId = questionnaireService.updateQuestionnaire(questionnaireDto);
        log.info("update questionnaire {}" , questionnaireDto.getName());
        return "redirect:/questionnaire/" + questionnaireId ;
    }

    @GetMapping("/questionnaire/{id}")
    public String questionnaireById(@PathVariable Long id, Model model){
        QuestionnaireDto questionnaireDto = questionnaireService.findById(id);
        model.addAttribute("questionnaire", questionnaireDto);
        return "questionnaire";
    }

    @GetMapping("/delete-questionnaire/{id}")
    public String deleteQuestionnaireById(@PathVariable Long id){
        questionnaireService.deleteQuestionnaireById(id);
        log.info("delete questionnaire by id {}" , id);
        return "redirect:/index";
    }

    @GetMapping("fill-questionnaire/{id}")
    public String fillQuestionnaire(@PathVariable Long id, Principal principal, Model model) {
        UserDto userDto = userDetailsServiceImpl.findByEmail(principal.getName());
        QuestionnaireDto questionnaireDto = questionnaireService.findById(id);
        List<QuestionDto> questionsDto = questionnaireDto.getQuestionsDto();
        model.addAttribute("user", userDto);
        model.addAttribute("questionnaire", questionnaireDto);
        model.addAttribute("questions", questionsDto);
        log.info("fill questionnaire  {} for user {} ", questionnaireDto.getName(), userDto.getName());
        return "fill-questionnaire";
    }

    @PostMapping("/save-results")
    public String saveResults(Principal principal, HttpServletRequest request) {
        UserDto userDto = userDetailsServiceImpl.findByEmail(principal.getName());
        userDetailsService.saveResults(userDto, request);
        log.info("save results fill questionnaire for user {}", userDto.getName());
        return "redirect:/index";
    }

}
