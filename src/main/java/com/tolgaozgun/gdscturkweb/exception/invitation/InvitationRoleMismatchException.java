package com.tolgaozgun.gdscturkweb.exception.invitation;

import com.tolgaozgun.gdscturkweb.enums.UserType;
import com.tolgaozgun.gdscturkweb.exception.BaseException;
import org.springframework.http.HttpStatus;

public class InvitationRoleMismatchException extends BaseException {
    public InvitationRoleMismatchException() {
        super("The invitation role and the user role are not the same!", HttpStatus.BAD_REQUEST);
    }

    public InvitationRoleMismatchException(UserType invitationRole, UserType userRole) {
        super("The invitation role and the user role are not the same! Invitation role: "
                + invitationRole + " User role: " + userRole, HttpStatus.BAD_REQUEST);
    }

}