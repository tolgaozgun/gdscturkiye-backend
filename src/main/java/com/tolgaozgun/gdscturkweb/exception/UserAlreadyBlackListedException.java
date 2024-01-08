package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyBlackListedException extends BaseException {
    public UserAlreadyBlackListedException() {
        super("User is already blacklisted!", HttpStatus.BAD_REQUEST);
    }

}
