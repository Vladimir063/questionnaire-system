package com.vladimir.questionnaire.exception;

public class UserNotFoundException extends RuntimeException  {

    public UserNotFoundException(String message) {
        super(message);
    }
}
