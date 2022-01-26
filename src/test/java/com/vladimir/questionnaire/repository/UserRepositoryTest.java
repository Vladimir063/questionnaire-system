package com.vladimir.questionnaire.repository;

import com.vladimir.questionnaire.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void findByEmail() {
        UserEntity userEntity = userRepository.findByEmail("ivan@mail.com")
                .orElseThrow(() -> new UsernameNotFoundException("test"));

        assertThat(userEntity.getEmail()).isEqualTo("ivan@mail.com");

    }
}