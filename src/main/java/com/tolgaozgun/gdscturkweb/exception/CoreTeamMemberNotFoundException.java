package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class CoreTeamMemberNotFoundException extends BaseException {
    public CoreTeamMemberNotFoundException() {
        super("Core team member not found!", HttpStatus.NOT_FOUND);
    }
}
