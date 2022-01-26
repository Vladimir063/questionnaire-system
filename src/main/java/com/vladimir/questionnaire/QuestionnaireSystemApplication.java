package com.vladimir.questionnaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//	(exclude = SecurityAutoConfiguration.class)
public class QuestionnaireSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionnaireSystemApplication.class, args);
	}

}
