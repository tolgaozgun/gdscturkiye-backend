package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class BuddyTeamNotFoundException extends BaseException {
    public BuddyTeamNotFoundException() {
        super("Buddy team not found!", HttpStatus.NOT_FOUND);
    }
}
