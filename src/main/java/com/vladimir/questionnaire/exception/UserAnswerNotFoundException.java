package com.vladimir.questionnaire.exception;

public class UserAnswerNotFoundException extends RuntimeException {

    public UserAnswerNotFoundException(String message) {
        super(message);
    }
}
