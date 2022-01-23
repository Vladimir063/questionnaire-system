package com.vladimir.questionnaire_app.exception;

public class UserNotFoundException extends RuntimeException  {

    public UserNotFoundException(String message) {
        super(message);
    }
}
