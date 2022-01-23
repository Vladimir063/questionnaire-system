package com.vladimir.questionnaire_app.services.impl;

import com.vladimir.questionnaire_app.dto.UserDto;
import com.vladimir.questionnaire_app.entity.UserEntity;
import com.vladimir.questionnaire_app.exception.UserNotFoundException;
import com.vladimir.questionnaire_app.mapper.UserMapper;
import com.vladimir.questionnaire_app.repository.UserRepository;
import com.vladimir.questionnaire_app.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service("userDetailsServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         UserEntity user = userRepository.findByEmail(username).orElseThrow(() ->
                     new UsernameNotFoundException("User не найден"));

        return SecurityUser.fromUser(user);
    }

    public UserEntity findById(Long id){
        UserEntity userEntity = userRepository.findById(id).
                orElseThrow(() -> new IllegalStateException());
        return userEntity;
    }

//    public List<UserEntity> findAll(){
//        return userRepository.findAll();
//    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

//    public UserEntity findByEmail(String email){
//        UserEntity userEntity = userRepository.findByEmail(email)
//                .orElseThrow(() -> new IllegalStateException());
//        return userEntity;
//    }

    public UserDto findByEmail(String email){
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("user not found by email = " + email));
        return userMapper.userToDto(userEntity);
    }
}
