package com.tolgaozgun.gdscturkweb.exception.verification;

import com.tolgaozgun.gdscturkweb.exception.BaseException;
import org.springframework.http.HttpStatus;

public class EmailVerificationAlreadyUsedException extends BaseException {
    public EmailVerificationAlreadyUsedException() {
        super("This email verification is already used!", HttpStatus.BAD_REQUEST);
    }

}