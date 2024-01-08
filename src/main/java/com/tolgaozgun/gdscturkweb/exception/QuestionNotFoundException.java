package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class QuestionNotFoundException extends BaseException {
    public QuestionNotFoundException() {
        super("Question not found!", HttpStatus.NOT_FOUND);
    }

    public QuestionNotFoundException(Long questionId) {
        super("Question with ID " + questionId + " not found!", HttpStatus.NOT_FOUND);
    }

}
