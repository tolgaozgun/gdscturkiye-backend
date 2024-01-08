package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class CountryNotFoundException extends BaseException {
    public CountryNotFoundException() {
        super("Country not found!", HttpStatus.NOT_FOUND);
    }
}
