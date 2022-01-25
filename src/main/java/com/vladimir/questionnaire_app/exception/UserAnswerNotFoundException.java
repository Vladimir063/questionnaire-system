package com.vladimir.questionnaire_app.exception;

public class UserAnswerNotFoundException extends RuntimeException {

    public UserAnswerNotFoundException(String message) {
        super(message);
    }
}
