package com.tolgaozgun.gdscturkweb.exception.invitation;

import com.tolgaozgun.gdscturkweb.exception.BaseException;
import org.springframework.http.HttpStatus;

public class InvitationNotFoundException extends BaseException {
    public InvitationNotFoundException() {
        super("Invitation not found!", HttpStatus.NOT_FOUND);
    }

}