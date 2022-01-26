package com.vladimir.questionnaire.services.impl;

import com.vladimir.questionnaire.dto.AnswerDto;
import com.vladimir.questionnaire.dto.QuestionDto;
import com.vladimir.questionnaire.entity.QuestionEntity;
import com.vladimir.questionnaire.exception.QuestionNotFoundException;
import com.vladimir.questionnaire.mapper.QuestionMapper;
import com.vladimir.questionnaire.repository.QuestionCustomRepository;
import com.vladimir.questionnaire.repository.QuestionRepository;
import com.vladimir.questionnaire.services.QuestionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionMapper questionMapper;
    private final QuestionRepository questionRepository;
    private final QuestionCustomRepository questionCustomRepository;

    @Override
    @Transactional
    public Long saveOrUpdateQuestion(QuestionDto questionDto) {
        QuestionEntity questionEntity = questionMapper.questionToEntity(questionDto);
        if (questionEntity.getId() == null) {
            QuestionEntity questionEntitySave = questionRepository.save(questionEntity);
            return questionEntitySave.getId();
        } else {
            QuestionEntity questionEntityUpdate = questionCustomRepository.updateQuestion(questionEntity);
            return questionEntityUpdate.getId();
        }
    }

    @Override
    public QuestionDto findById(Long id) {
        QuestionEntity questionEntity = questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found by id = " + id));
        return questionMapper.questionToDto(questionEntity);
    }

    @Override
    @Transactional
    public void deleteQuestionById(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Long updateQuestion(QuestionDto questionDto) {
        QuestionEntity questionEntity = questionMapper.questionToEntity(questionDto);
        QuestionEntity questionEntityUpdate = questionCustomRepository.updateQuestion(questionEntity);
        return questionEntityUpdate.getId();
    }

    @Override
    @Transactional
    public void initListAnswer(QuestionDto questionDto) {
        List<AnswerDto> answersDto = questionDto.getAnswersDto();
        if (answersDto.isEmpty()) {
            for (int i=0; i< questionDto.getCountAnswer(); i++){
                AnswerDto answerDto = new AnswerDto();
                answerDto.setQuestionId(questionDto.getId());
                questionDto.addAnswer(answerDto);
            }
        } else{
            if (questionDto.getCountAnswer() < answersDto.size()) {
                for (int i = answersDto.size() ; i > questionDto.getCountAnswer(); i--) {
                    AnswerDto answerDto = answersDto.get(answersDto.size() - 1);
                    answersDto.remove(answerDto);
                }

            } else {
                for (int i= answersDto.size(); i< questionDto.getCountAnswer(); i++){
                    AnswerDto answerDto = new AnswerDto();
                    answerDto.setQuestionId(questionDto.getId());
                    questionDto.addAnswer(answerDto);
                }
            }
        }
    }
}
