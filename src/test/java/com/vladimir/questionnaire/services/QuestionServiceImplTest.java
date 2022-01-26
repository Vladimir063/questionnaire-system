package com.vladimir.questionnaire.services;

import com.vladimir.questionnaire.dto.QuestionDto;
import com.vladimir.questionnaire.entity.QuestionEntity;
import com.vladimir.questionnaire.mapper.QuestionMapper;
import com.vladimir.questionnaire.repository.QuestionCustomRepository;
import com.vladimir.questionnaire.repository.QuestionRepository;
import com.vladimir.questionnaire.services.impl.QuestionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class QuestionServiceImplTest {

    @Mock
    QuestionMapper questionMapper;
    @Mock
    QuestionRepository questionRepository;
    @Mock
    QuestionCustomRepository questionCustomRepository;
    @InjectMocks
    QuestionServiceImpl questionServiceImpl;

    QuestionEntity questionEntity;

    QuestionDto questionDto;


    @BeforeEach
    void init() {
        questionEntity = new QuestionEntity();
        questionEntity.setId(20L);
        questionEntity.setName("Откуда Вы?");
        questionRepository.save(questionEntity);

        questionDto = new QuestionDto();
        questionDto.setId(20L);
        questionDto.setName("Откуда Вы?");
    }


    @Test
    void findById() {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId(1L);
        Optional<QuestionEntity> maybeQuestion = Optional.of(questionEntity);

        when(questionRepository.findById(anyLong())).thenReturn(maybeQuestion);

        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(1L);

        when(questionMapper.questionToDto(any())).thenReturn(questionDto);

        QuestionDto questionDtoDtoById = questionServiceImpl.findById(1L);

        assertNotNull(questionDtoDtoById, "Null restaurant returned");
        verify(questionRepository, times(1)).findById(anyLong());
    }

    @Test
    void deleteQuestionById() {
        questionServiceImpl.deleteQuestionById(1L);
        verify(questionRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void updateQuestion() {
        QuestionEntity questionEntity2 = new QuestionEntity();
        questionEntity2.setId(21L);
        questionEntity2.setName("Из какого вы города?");

        when(questionMapper.questionToEntity(questionDto)).thenReturn(questionEntity2);
        when(questionCustomRepository.updateQuestion(questionEntity2)).thenReturn(questionEntity2);

        Long questionId = questionServiceImpl.updateQuestion(questionDto);
        assertThat(questionId).isEqualTo(21L);

    }

}