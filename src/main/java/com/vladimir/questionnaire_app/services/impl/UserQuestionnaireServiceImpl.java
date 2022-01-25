package com.vladimir.questionnaire_app.services.impl;

import com.vladimir.questionnaire_app.dto.AnswerDto;
import com.vladimir.questionnaire_app.dto.UserAnswerDto;
import com.vladimir.questionnaire_app.dto.UserDto;
import com.vladimir.questionnaire_app.dto.UserQuestionnaireDto;
import com.vladimir.questionnaire_app.entity.*;
import com.vladimir.questionnaire_app.exception.AnswerNotFoundException;
import com.vladimir.questionnaire_app.mapper.UserMapper;
import com.vladimir.questionnaire_app.mapper.UserQuestionnaireMapper;
import com.vladimir.questionnaire_app.repository.AnswerRepository;
import com.vladimir.questionnaire_app.repository.UserAnswerRepository;
import com.vladimir.questionnaire_app.repository.UserQuestionnaireRepository;
import com.vladimir.questionnaire_app.services.UserQuestionnaireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserQuestionnaireServiceImpl implements UserQuestionnaireService {

    private final UserQuestionnaireRepository userQuestionnaireRepository;
    private final UserDetailServiceImpl userDetailsServiceImpl;
    private final UserMapper userMapper;
    private final AnswerRepository answerRepository;
    private final UserAnswerRepository userAnswerRepository;
    private final UserQuestionnaireMapper userQuestionnaireMapper;

    @Override
    public List<UserQuestionnaireDto> findAll() {
        List<UserQuestionnaireEntity> userQuestionnaireList = userQuestionnaireRepository.findAll();
        return userQuestionnaireList.stream().map(userQuestionnaireMapper::userQuestionnaireToDto).collect(Collectors.toList());
    }

    @Override
    public void saveResults(UserDto userDto, HttpServletRequest request) {
        UserEntity userEntity = userMapper.userToEntity(userDto);
        Map<String, String[]> parameterMap = request.getParameterMap();  // мапа для отображения нескольких ответов на один вопрос
        QuestionnaireEntity questionnaireEntity = null;
        System.out.println();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()){

            UserAnswerEntity userAnswerEntity = new UserAnswerEntity();  // создаем новую сущность многие ко многим для сохранения ответов для юзера.
            userAnswerEntity.setUserEntity(userEntity);   // сэтим в сущность юзера

            String answerId = entry.getValue()[0];   // вынимаем из мапы, которая пришла с фронта айди ответа
            AnswerEntity answerEntity = answerRepository.findById(Long.parseLong(answerId))   // находим сущность ответа по его айди
                    .orElseThrow(() -> new AnswerNotFoundException("answerId not found by id = " + answerId));


            userAnswerEntity.setAnswerEntity(answerEntity);   // сэтим в сущность вопрос
            userAnswerRepository.save(userAnswerEntity);  // сохраняем результаты ответов для юзера
            questionnaireEntity = answerEntity.getQuestionEntity().getQuestionnaireEntity();

            System.out.println();
        }

        UserQuestionnaireEntity userQuestionnaireEntity = new UserQuestionnaireEntity();  // создаем сущность многие ко многим для сохранения, что юзер заполнил анкету
        userQuestionnaireEntity.setUserEntity(userEntity);
        userQuestionnaireEntity.setQuestionnaireEntity(questionnaireEntity);
        userQuestionnaireRepository.save(userQuestionnaireEntity);
        System.out.println();
    }
}
