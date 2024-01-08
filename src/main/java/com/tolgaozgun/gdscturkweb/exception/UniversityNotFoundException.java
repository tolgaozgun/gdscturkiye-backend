package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class UniversityNotFoundException extends BaseException {
    public UniversityNotFoundException() {
        super("University not found!", HttpStatus.NOT_FOUND);
    }
}
