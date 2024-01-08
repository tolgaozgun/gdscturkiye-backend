package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class CoreTeamNotFoundException extends BaseException {
    public CoreTeamNotFoundException() {
        super("Core team not found!", HttpStatus.NOT_FOUND);
    }
}
