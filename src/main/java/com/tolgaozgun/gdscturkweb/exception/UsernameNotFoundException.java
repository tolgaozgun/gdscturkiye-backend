package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class UsernameNotFoundException extends BaseException {
    public UsernameNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
