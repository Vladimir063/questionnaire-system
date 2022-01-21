package com.vladimir.questionnaire_app.services.impl;

import com.vladimir.questionnaire_app.dto.QuestionnaireDto;
import com.vladimir.questionnaire_app.entity.QuestionnaireEntity;
import com.vladimir.questionnaire_app.exception.QuestionnaireNotFoundException;
import com.vladimir.questionnaire_app.mapper.QuestionnaireMapper;
import com.vladimir.questionnaire_app.repository.QuestionnaireCustomRepository;
import com.vladimir.questionnaire_app.repository.QuestionnaireRepository;
import com.vladimir.questionnaire_app.services.QuestionnaireService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionnaireMapper questionnaireMapper;
    private final QuestionnaireCustomRepository questionnaireCustomRepository;

    @Override
    public List<QuestionnaireDto> findAll() {
        List<QuestionnaireEntity> questionnaireEntities = questionnaireRepository.findAll();
        return questionnaireEntities.stream().map(questionnaireMapper::questionnaireToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Long saveQuestionnaire(QuestionnaireDto questionnaireDto) {
        QuestionnaireEntity questionnaireEntity = questionnaireMapper.questionnaireToEntity(questionnaireDto);
        QuestionnaireEntity questionnaireEntitySave =  questionnaireRepository.save(questionnaireEntity);
        return questionnaireEntitySave.getId();
    }

    @Override
    @Transactional
    public Long updateQuestionnaire(QuestionnaireDto questionnaireDto) {
        QuestionnaireEntity questionnaireEntity = questionnaireMapper.questionnaireToEntity(questionnaireDto);
        QuestionnaireEntity questionnaireEntityUpdate =  questionnaireCustomRepository.updateQuestionnaire(questionnaireEntity);
        return questionnaireEntityUpdate.getId();
    }

    @Override
    public QuestionnaireDto findById(Long id) {
        QuestionnaireEntity questionnaireEntity = questionnaireRepository.findById(id)
                .orElseThrow(() -> new QuestionnaireNotFoundException("Questionnaire not found by id = " + id));
        return questionnaireMapper.questionnaireToDto(questionnaireEntity);
    }

    @Override
    @Transactional
    public void deleteQuestionnaireById(Long id) {
        questionnaireRepository.deleteById(id);
    }


}
