package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class NotPermittedException  extends BaseException {
    public NotPermittedException() {
        super("You are not permitted to do this action!", HttpStatus.FORBIDDEN);
    }

}
