package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class FacilitatorNotFoundException extends BaseException {
    public FacilitatorNotFoundException() {
        super("Facilitator not found!", HttpStatus.NOT_FOUND);
    }
}
