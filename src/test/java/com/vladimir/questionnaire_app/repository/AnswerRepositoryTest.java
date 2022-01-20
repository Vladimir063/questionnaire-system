package com.vladimir.questionnaire_app.repository;

import com.vladimir.questionnaire_app.entity.AnswerEntity;
import com.vladimir.questionnaire_app.mapper.AnswerMapper;
import com.vladimir.questionnaire_app.mapper.QuestionMapper;
import com.vladimir.questionnaire_app.mapper.QuestionnaireMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // для использования БД не из памяти
class AnswerRepositoryTest {

    @Autowired
    private AnswerRepository answerRepository;



    @Test
    void findAll(){
        AnswerEntity maybeAnswerEntity = answerRepository.findById(1L).get();
        System.out.println(maybeAnswerEntity);

    }
}