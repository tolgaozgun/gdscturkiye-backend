package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class UserTypeNotFoundException extends BaseException {
    public UserTypeNotFoundException() {
        super("Error while getting user type details", HttpStatus.NOT_FOUND);
    }
}
