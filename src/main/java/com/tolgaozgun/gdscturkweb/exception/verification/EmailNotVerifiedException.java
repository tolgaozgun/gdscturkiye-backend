package com.tolgaozgun.gdscturkweb.exception.verification;

import com.tolgaozgun.gdscturkweb.exception.BaseException;
import org.springframework.http.HttpStatus;

public class EmailNotVerifiedException extends BaseException {
    public EmailNotVerifiedException() {
        super("Email is not verified!", HttpStatus.BAD_REQUEST);
    }
}