package com.vladimir.questionnaire_app.services.impl;

import com.vladimir.questionnaire_app.dto.UserDto;
import com.vladimir.questionnaire_app.entity.UserEntity;
import com.vladimir.questionnaire_app.entity.enums.Status;
import com.vladimir.questionnaire_app.mapper.UserMapper;
import com.vladimir.questionnaire_app.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public void saveUser(UserDto userDto){
        UserEntity userEntity = userMapper.userToEntity(userDto);
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userEntity.setStatus(Status.ACTIVE);
        userRepository.save(userEntity);
        log.info("user {} registration", userDto.getName() );
    }
}
