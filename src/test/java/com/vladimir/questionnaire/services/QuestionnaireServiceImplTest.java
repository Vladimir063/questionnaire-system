package com.vladimir.questionnaire.services;

import com.vladimir.questionnaire.dto.QuestionnaireDto;
import com.vladimir.questionnaire.entity.QuestionnaireEntity;
import com.vladimir.questionnaire.mapper.QuestionnaireMapper;
import com.vladimir.questionnaire.repository.QuestionnaireRepository;
import com.vladimir.questionnaire.services.impl.QuestionnaireServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class QuestionnaireServiceImplTest {
    @Mock
    QuestionnaireRepository questionnaireRepository;
    @Mock
    QuestionnaireMapper questionnaireMapper;


    @InjectMocks
    QuestionnaireServiceImpl questionnaireServiceImpl;

    QuestionnaireEntity questionnaireEntity1;
    QuestionnaireEntity questionnaireEntity2;

    QuestionnaireDto questionnaireDto1;
    QuestionnaireDto questionnaireDto2;

    List<QuestionnaireEntity> questionnaireEntityList = new ArrayList<>();
    List<QuestionnaireDto> questionnaireDtoList = new ArrayList<>();

    @BeforeEach
    public void init() {
        questionnaireEntity1 = new QuestionnaireEntity();
        questionnaireEntity1.setId(10L);
        questionnaireEntity1.setName("Music");

        questionnaireEntity2 = new QuestionnaireEntity();
        questionnaireEntity2.setId(11L);
        questionnaireEntity2.setName("Food");

        questionnaireDto1 = new QuestionnaireDto();
        questionnaireDto1.setId(10L);
        questionnaireDto1.setName("Music");

        questionnaireDto2 = new QuestionnaireDto();
        questionnaireDto2.setId(11L);
        questionnaireDto2.setName("Food");

        questionnaireEntityList.add(questionnaireEntity1);
        questionnaireEntityList.add(questionnaireEntity2);
        questionnaireDtoList.add(questionnaireDto1);
        questionnaireDtoList.add(questionnaireDto2);

    }

    @Test
    void findAll() {
        when(questionnaireRepository.findAll()).thenReturn(questionnaireEntityList);
        when(questionnaireMapper.questionnaireToDto(questionnaireEntity1)).thenReturn(questionnaireDto1);
        when(questionnaireMapper.questionnaireToDto(questionnaireEntity2)).thenReturn(questionnaireDto2);

        List<QuestionnaireDto> dtoListFind = questionnaireServiceImpl.findAll();

        assertThat(dtoListFind).hasSize(2);
        assertThat(dtoListFind.get(0).getId()).isEqualTo(10L);
        assertThat(dtoListFind.get(1).getId()).isEqualTo(11L);

    }


    @Test
    void findById() {
        when(questionnaireRepository.findById(anyLong())).thenReturn(Optional.of(questionnaireEntity1));
        when(questionnaireMapper.questionnaireToDto(questionnaireEntity1)).thenReturn(questionnaireDto1);

        QuestionnaireDto questionnaireDtoFind = questionnaireServiceImpl.findById(10L);

        assertThat(questionnaireDtoFind.getId()).isEqualTo(questionnaireDto1.getId());
    }

    @Test
    void deleteQuestionnaireById() {
        questionnaireServiceImpl.deleteQuestionnaireById(anyLong());

        verify(questionnaireRepository, times(1)).deleteById(anyLong());
    }
}

