package com.vladimir.questionnaire_app.exception;

public class QuestionNotFoundException extends RuntimeException  {

    public QuestionNotFoundException(String message) {
        super(message);
    }
}
