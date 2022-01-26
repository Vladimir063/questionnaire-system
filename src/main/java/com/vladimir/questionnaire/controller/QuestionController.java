package com.vladimir.questionnaire.controller;

import com.vladimir.questionnaire.dto.QuestionDto;
import com.vladimir.questionnaire.dto.QuestionnaireDto;
import com.vladimir.questionnaire.services.QuestionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
@Slf4j
@Controller
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/add-new-question")
    public String addNewQuestion(@ModelAttribute QuestionnaireDto questionnaireDto , Model model) {
        log.info("start add new question for questionnaire {}" , questionnaireDto.getName());
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionnaireId(questionnaireDto.getId());
        questionDto.setQuestionnaireName(questionnaireDto.getName());
        model.addAttribute("question", questionDto);
        return "form-question";
    }

    @PostMapping("/save-or-update-question")
    public String saveQuestion(@Valid @ModelAttribute("question") QuestionDto questionDto, BindingResult result ) {
        if (result.hasErrors()) {
            log.info("error validation when user saved question");
            return "form-question";
        }
        Long questionId = questionService.saveOrUpdateQuestion(questionDto);
        return "redirect:/question/" + questionId + "/add-new-answers";
    }

    @GetMapping("/question/{id}/add-new-answers")
    public String questionById(@PathVariable Long id, Model model, HttpSession session) {
        log.info("start add new answers for question {}" , id);
        QuestionDto questionDto = questionService.findById(id);
        questionService.initListAnswer(questionDto);
        model.addAttribute("question", questionDto);
        session.setAttribute("question", questionDto);
        return "add-new-answers";
    }

    @GetMapping("/delete-question/{id}")
    public String deleteQuestionById(@PathVariable Long id){
        log.info("delete question with id = {}", id);
        QuestionDto questionDto = questionService.findById(id);  // ищем questionDto, чтобы взять id анкеты и сделать редирект на страницу анкеты
        questionService.deleteQuestionById(id);
        return "redirect:/questionnaire/" + questionDto.getQuestionnaireId();
    }

    @GetMapping("/edit-question/{id}")
    public String editQuestion(@PathVariable Long id, Model model){
        log.info("edit question with id = {}", id);
        QuestionDto questionDto = questionService.findById(id);
        model.addAttribute("question", questionDto);
        return "form-question";
    }
}
