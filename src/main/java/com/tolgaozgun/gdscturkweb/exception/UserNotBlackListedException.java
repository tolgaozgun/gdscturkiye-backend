package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class UserNotBlackListedException extends BaseException {
    public UserNotBlackListedException() {
        super("User is not blacklisted!", HttpStatus.BAD_REQUEST);
    }

}
