package com.vladimir.questionnaire.services.impl;

import com.vladimir.questionnaire.dto.UserDto;
import com.vladimir.questionnaire.entity.UserEntity;
import com.vladimir.questionnaire.entity.enums.Status;
import com.vladimir.questionnaire.mapper.UserMapper;
import com.vladimir.questionnaire.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@AllArgsConstructor
@Service
public class RegistrationService implements com.vladimir.questionnaire.services.RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void saveUser(UserDto userDto){
        UserEntity userEntity = userMapper.userToEntity(userDto);
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userEntity.setStatus(Status.ACTIVE);
        userRepository.save(userEntity);
        log.info("user {} registration", userDto.getName() );
    }
}
