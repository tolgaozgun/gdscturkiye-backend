package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class CityNotFoundException extends BaseException {
    public CityNotFoundException() {
        super("City not found!", HttpStatus.NOT_FOUND);
    }
}
