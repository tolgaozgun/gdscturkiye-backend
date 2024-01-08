package com.tolgaozgun.gdscturkweb.exception.invitation;

import com.tolgaozgun.gdscturkweb.enums.UserType;
import com.tolgaozgun.gdscturkweb.exception.BaseException;
import org.springframework.http.HttpStatus;

public class InvitationIsNotValidException extends BaseException {
    public InvitationIsNotValidException() {
        super("The invitation is not valid!", HttpStatus.BAD_REQUEST);
    }

}