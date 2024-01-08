package com.tolgaozgun.gdscturkweb.exception.verification;

import com.tolgaozgun.gdscturkweb.exception.BaseException;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class EmailVerificationExpiredException extends BaseException {

    public EmailVerificationExpiredException() {
        super("Email verification expired!", HttpStatus.BAD_REQUEST);
    }

    public EmailVerificationExpiredException(Date date) {
        super("Email verification expired at " + date.toString(), HttpStatus.BAD_REQUEST);
    }
}