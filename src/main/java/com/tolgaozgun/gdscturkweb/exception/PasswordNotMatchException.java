package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class PasswordNotMatchException extends BaseException {
    public PasswordNotMatchException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
