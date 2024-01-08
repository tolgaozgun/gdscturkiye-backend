package com.tolgaozgun.gdscturkweb.exception.verification;


import com.tolgaozgun.gdscturkweb.exception.BaseException;
import org.springframework.http.HttpStatus;

public class UserAlreadyUnverifiedException extends BaseException {
    public UserAlreadyUnverifiedException() {
        super("User is  already unverified!", HttpStatus.BAD_REQUEST);
    }
}