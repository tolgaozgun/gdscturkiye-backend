package com.tolgaozgun.gdscturkweb.controller;

import com.tolgaozgun.gdscturkweb.dto.request.verification.EmailResendRequest;
import com.tolgaozgun.gdscturkweb.dto.request.verification.EmailVerificationRequest;
import com.tolgaozgun.gdscturkweb.dto.response.Response;
import com.tolgaozgun.gdscturkweb.exception.BaseException;
import com.tolgaozgun.gdscturkweb.exception.ExceptionLogger;
import com.tolgaozgun.gdscturkweb.model.City;
import com.tolgaozgun.gdscturkweb.service.CityService;
import com.tolgaozgun.gdscturkweb.service.EmailVerificationService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("email-verification")
public class EmailVerificationController {

    private final EmailVerificationService emailVerificationService;

    @PostMapping( path = "verify")
    public ResponseEntity<Object> verifyEmail(@RequestBody @NotNull EmailVerificationRequest emailVerificationRequest) {
        try {
            String email = emailVerificationService.verifyEmail(emailVerificationRequest);
            return Response.create("Verified email for "  + email,
                    HttpStatus.OK, email);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping( path = "resend")
    public ResponseEntity<Object> resendVerificationCode(@RequestBody @NotNull EmailResendRequest emailResendRequest) {
        try {
            String email = emailVerificationService.resendVerification(emailResendRequest);
            return Response.create("Resent verification code for "  + email,
                    HttpStatus.OK, email);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
