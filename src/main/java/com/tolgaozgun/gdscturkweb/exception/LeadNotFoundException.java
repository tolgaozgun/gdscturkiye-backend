package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class LeadNotFoundException extends BaseException {
    public LeadNotFoundException() {
        super("Lead not found!", HttpStatus.NOT_FOUND);
    }
}
