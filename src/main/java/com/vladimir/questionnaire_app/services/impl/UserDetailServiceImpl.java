package com.vladimir.questionnaire_app.services.impl;

import com.vladimir.questionnaire_app.entity.UserEntity;
import com.vladimir.questionnaire_app.repository.UserRepository;
import com.vladimir.questionnaire_app.security.SecurityUser;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service("userDetailsServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
}
