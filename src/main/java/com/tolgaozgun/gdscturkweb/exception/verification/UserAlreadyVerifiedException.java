package com.tolgaozgun.gdscturkweb.exception.verification;

import com.tolgaozgun.gdscturkweb.exception.BaseException;
import org.springframework.http.HttpStatus;

public class UserAlreadyVerifiedException extends BaseException {
    public UserAlreadyVerifiedException() {
        super("User is already verified!", HttpStatus.BAD_REQUEST);
    }
}