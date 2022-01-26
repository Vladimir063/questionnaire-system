package com.vladimir.questionnaire.controller;

import com.vladimir.questionnaire.dto.UserDto;
import com.vladimir.questionnaire.services.impl.RegistrationService;
import com.vladimir.questionnaire.services.impl.UserDetailServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Slf4j
@Controller
@AllArgsConstructor
public class AuthController {

    private final UserDetailServiceImpl userDetailService;
    private final RegistrationService registrationService;


    @GetMapping("/auth/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/auth/login-error")
    public String getLoginPageError(Model model) {
        model.addAttribute("loginError", true);
        log.info("login with wrong username or password");
        return "login";
    }

    @GetMapping("/auth/success")
    public String getSuccessPage(Principal principal) {
        log.info("Successful login {}" , principal.getName());
        return "redirect:/";
    }

    @GetMapping("/auth/registration")
    public String getRegistrationPage(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/auth/save-user")
    public String saveUser(@ModelAttribute UserDto userDto){
        log.info("save new user");
        registrationService.saveUser(userDto);
        return "redirect:/";
    }
}