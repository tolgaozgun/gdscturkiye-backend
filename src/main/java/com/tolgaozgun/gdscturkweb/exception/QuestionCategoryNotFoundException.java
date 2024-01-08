package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class QuestionCategoryNotFoundException extends BaseException {
    public QuestionCategoryNotFoundException() {
        super("Question category not found!", HttpStatus.NOT_FOUND);
    }

    public QuestionCategoryNotFoundException(Long categoryId) {
        super("Question cateogry with ID " + categoryId + " not found!", HttpStatus.NOT_FOUND);
    }

}
