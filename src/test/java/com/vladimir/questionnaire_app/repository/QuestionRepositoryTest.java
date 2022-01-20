package com.vladimir.questionnaire_app.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // для использования БД не из памяти
class QuestionRepositoryTest {

    @Autowired
    QuestionRepository questionRepository;


    @Test
    void findById(){
        System.out.println(questionRepository.findById(1L).get());
    }

}