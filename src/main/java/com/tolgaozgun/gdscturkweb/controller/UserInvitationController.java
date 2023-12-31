package com.tolgaozgun.gdscturkweb.controller;

import com.tolgaozgun.gdscturkweb.dto.request.invitation.InviteUserRequest;
import com.tolgaozgun.gdscturkweb.dto.request.verification.EmailResendRequest;
import com.tolgaozgun.gdscturkweb.dto.request.verification.EmailVerificationRequest;
import com.tolgaozgun.gdscturkweb.dto.response.Response;
import com.tolgaozgun.gdscturkweb.dto.response.UserInvitationResponse;
import com.tolgaozgun.gdscturkweb.exception.BaseException;
import com.tolgaozgun.gdscturkweb.exception.ExceptionLogger;
import com.tolgaozgun.gdscturkweb.service.EmailVerificationService;
import com.tolgaozgun.gdscturkweb.service.UserInvitationService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("invitation")
public class UserInvitationController {

    private final UserInvitationService userInvitationService;

    @PostMapping( path = "invite")
    public ResponseEntity<Object> inviteUser(@RequestBody @NotNull InviteUserRequest inviteUserRequest) {
        try {
            System.out.println("inviteUserRequest: " + inviteUserRequest);
            UserInvitationResponse response = userInvitationService.createInvitationResponse(inviteUserRequest);
            return Response.create("Successfully invited user", HttpStatus.OK, response);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping( path = "cancel/{invitationId}")
    public ResponseEntity<Object> cancelInvitation(@PathVariable Long invitationId) {
        try {
            UserInvitationResponse response = userInvitationService.cancelInvitation(invitationId);
            return Response.create("Successfully cancelled the invite", HttpStatus.OK, response);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
