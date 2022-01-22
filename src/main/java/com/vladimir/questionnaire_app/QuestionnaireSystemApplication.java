package com.vladimir.questionnaire_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//	(exclude = SecurityAutoConfiguration.class)
public class QuestionnaireSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionnaireSystemApplication.class, args);
	}

}
