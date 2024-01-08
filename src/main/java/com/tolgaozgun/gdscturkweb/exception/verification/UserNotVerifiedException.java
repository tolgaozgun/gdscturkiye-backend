package com.tolgaozgun.gdscturkweb.exception.verification;

import com.tolgaozgun.gdscturkweb.exception.BaseException;
import org.springframework.http.HttpStatus;

public class UserNotVerifiedException extends BaseException {
    public UserNotVerifiedException() {
        super("User is not verified!", HttpStatus.BAD_REQUEST);
    }
}
