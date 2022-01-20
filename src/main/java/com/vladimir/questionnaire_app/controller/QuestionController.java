package com.vladimir.questionnaire_app.controller;

import com.vladimir.questionnaire_app.dto.AnswerDto;
import com.vladimir.questionnaire_app.dto.QuestionDto;
import com.vladimir.questionnaire_app.dto.QuestionnaireDto;
import com.vladimir.questionnaire_app.services.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/add-new-question")
    public String addNewQuestion(@ModelAttribute QuestionnaireDto questionnaireDto , Model model) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionnaireId(questionnaireDto.getId());
        questionDto.setQuestionnaireName(questionnaireDto.getName());
        model.addAttribute("question", questionDto);
        return "form-creation-question";
    }

    @PostMapping("/save-question")
    public String saveQuestion(@ModelAttribute QuestionDto questionDto , Model model) {
        Long questionId = questionService.saveQuestion(questionDto);
        return "redirect:/question/" + questionId + "/add-new-answers";
    }

    @GetMapping("/question/{id}/add-new-answers")
    public String questionById(@PathVariable Long id, Model model) {
        QuestionDto questionDto = questionService.findById(id);
        for (int i=0; i< questionDto.getCountAnswer(); i++){
            AnswerDto answerDto = new AnswerDto();
            answerDto.setQuestionId(questionDto.getId());
            questionDto.addAnswer(answerDto);
        }
        model.addAttribute("question", questionDto);
        return "add-new-answers";
    }

}
