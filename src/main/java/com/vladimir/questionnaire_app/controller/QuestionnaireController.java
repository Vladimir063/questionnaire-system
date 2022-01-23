package com.vladimir.questionnaire_app.controller;

import com.vladimir.questionnaire_app.dto.QuestionDto;
import com.vladimir.questionnaire_app.dto.QuestionnaireDto;
import com.vladimir.questionnaire_app.entity.*;
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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.*;

@Controller
@AllArgsConstructor
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;
    private final UserDetailServiceImpl userDetailsServiceImpl;
    private final UserAnswerRepository userAnswerRepository;
    private final AnswerRepository answerRepository;
    private final UserQuestionnaireRepository userQuestionnaireRepository;


    @GetMapping({"", "/", "/index"})
    public String getIndexPage(Model model, Principal principal){
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
    public String saveQuestionnaire(@Valid @ModelAttribute("questionnaire") QuestionnaireDto questionnaireDto, BindingResult result) {
        if (result.hasErrors()) {
            return "new-questionnaire";
        }
        Long questionnaireId = questionnaireService.saveQuestionnaire(questionnaireDto);
        return "redirect:/questionnaire/" + questionnaireId ;
    }

    @GetMapping("/edit-questionnaire/{id}")
    public String editQuestionnaire(@PathVariable Long id, Model model) {
        QuestionnaireDto questionnaireDto = questionnaireService.findById(id);
        model.addAttribute("questionnaire", questionnaireDto);
        return "edit-questionnaire";
    }

    @PostMapping("/update-questionnaire")
    public String updateQuestionnaire(@ModelAttribute QuestionnaireDto questionnaireDto) {
        Long questionnaireId = questionnaireService.updateQuestionnaire(questionnaireDto);
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
        return "redirect:/index";
    }

    @GetMapping("fill-questionnaire/{id}")
    public String fillQuestionnaire(@PathVariable Long id, Principal principal, Model model) {

        UserEntity userEntity = userDetailsServiceImpl.findByEmail(principal.getName());
        QuestionnaireDto questionnaireDto = questionnaireService.findById(id);
        List<QuestionDto> questionsDto = questionnaireDto.getQuestionsDto();
        model.addAttribute("user", userEntity);
        model.addAttribute("questionnaire", questionnaireDto);
        model.addAttribute("questions", questionsDto);
        System.out.println();
        return "fill-questionnaire";
    }

    @PostMapping("/save-results")
    public String saveResults(Principal principal, HttpServletRequest request) {
        UserEntity userEntity = userDetailsServiceImpl.findByEmail(principal.getName());
        Map<String, String[]> parameterMap = request.getParameterMap();
        QuestionnaireEntity questionnaireEntity = null;
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()){

            UserAnswerEntity userAnswerEntity = new UserAnswerEntity();

            userAnswerEntity.setUserEntity(userEntity);

            String answerId = entry.getValue()[0];
            AnswerEntity answerEntity = answerRepository.findById(Long.parseLong(answerId)).get();
            userAnswerEntity.setAnswerEntity(answerEntity);
            userAnswerRepository.save(userAnswerEntity);
            questionnaireEntity = answerEntity.getQuestionEntity().getQuestionnaireEntity();
            System.out.println();
        }

        UserQuestionnaireEntity userQuestionnaireEntity = new UserQuestionnaireEntity();
        userQuestionnaireEntity.setUserEntity(userEntity);
        userQuestionnaireEntity.setQuestionnaireEntity(questionnaireEntity);
        userQuestionnaireRepository.save(userQuestionnaireEntity);
        System.out.println();
        return "redirect:/index";
    }

}
