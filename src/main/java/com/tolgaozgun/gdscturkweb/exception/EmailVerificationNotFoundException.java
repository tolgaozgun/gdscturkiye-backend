package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class EmailVerificationNotFoundException extends BaseException {
    public EmailVerificationNotFoundException() {
        super("Email verification is not found!", HttpStatus.NOT_FOUND);
    }

}