package com.tolgaozgun.gdscturkweb.exception.verification;

import com.tolgaozgun.gdscturkweb.exception.BaseException;
import org.springframework.http.HttpStatus;

public class EmailAlreadyVerifiedException extends BaseException {
    public EmailAlreadyVerifiedException() {
        super("Email is already verified!", HttpStatus.BAD_REQUEST);
    }
}