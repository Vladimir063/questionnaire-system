package com.vladimir.questionnaire_app.exception;

public class AnswerNotFoundException extends RuntimeException  {

    public AnswerNotFoundException(String message) {
        super(message);
    }
}
