package com.vladimir.questionnaire_app.services.impl;


import com.vladimir.questionnaire_app.dto.UserDto;
import com.vladimir.questionnaire_app.entity.UserEntity;
import com.vladimir.questionnaire_app.exception.UserNotFoundException;
import com.vladimir.questionnaire_app.mapper.UserMapper;
import com.vladimir.questionnaire_app.repository.UserRepository;
import com.vladimir.questionnaire_app.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service("userDetailsServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         UserEntity user = userRepository.findByEmail(username).orElseThrow(() ->
                 new UsernameNotFoundException("User not found by username = " + username));
        return SecurityUser.fromUser(user);
    }

    public UserDto findById(Long id){
        UserEntity userEntity = userRepository.findById(id).
                orElseThrow(() -> new UsernameNotFoundException("User not found by id = " + id));
        return userMapper.userToDto(userEntity);
    }

    public List<UserDto> findAll(){
        List<UserEntity> userEntityList = userRepository.findAll();
        return userEntityList.stream().map(userMapper::userToDto).collect(Collectors.toList());
    }

    public UserDto findByEmail(String email){
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("user not found by email = " + email));
        return userMapper.userToDto(userEntity);
    }
}
