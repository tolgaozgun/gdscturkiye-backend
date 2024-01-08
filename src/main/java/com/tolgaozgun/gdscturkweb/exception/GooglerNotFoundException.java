package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class GooglerNotFoundException extends BaseException {
    public GooglerNotFoundException() {
        super("Googler not found!", HttpStatus.NOT_FOUND);
    }
}
