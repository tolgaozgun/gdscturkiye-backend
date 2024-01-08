package com.tolgaozgun.gdscturkweb.exception.invitation;

import com.tolgaozgun.gdscturkweb.exception.BaseException;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class InvitationIsExpiredException extends BaseException {
    public InvitationIsExpiredException() {
        super("The invitation has expired!", HttpStatus.BAD_REQUEST);
    }

    public InvitationIsExpiredException(Date expirationDate) {
        super("The invitation has expired! Expiration date: " + expirationDate, HttpStatus.BAD_REQUEST);
    }

}