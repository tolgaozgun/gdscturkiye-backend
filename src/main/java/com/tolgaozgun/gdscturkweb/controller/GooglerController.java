package com.tolgaozgun.gdscturkweb.controller;

import com.tolgaozgun.gdscturkweb.dto.FacilitatorDTO;
import com.tolgaozgun.gdscturkweb.dto.GooglerDTO;
import com.tolgaozgun.gdscturkweb.dto.request.register.FacilitatorRegisterRequest;
import com.tolgaozgun.gdscturkweb.dto.request.register.GooglerRegisterRequest;
import com.tolgaozgun.gdscturkweb.dto.response.Response;
import com.tolgaozgun.gdscturkweb.exception.BaseException;
import com.tolgaozgun.gdscturkweb.exception.ExceptionLogger;
import com.tolgaozgun.gdscturkweb.service.GooglerService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("googlers")
public class GooglerController {

    private final GooglerService googlerService;

    @GetMapping( path = "")
    public ResponseEntity<Object> getAllCoreTeamMembers() {
        try {
            List<GooglerDTO> googlers = googlerService.getAllGooglers();
            return Response.create("Gathered all googlers", HttpStatus.OK, googlers);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping( path = "create")
    public ResponseEntity<Object> createGoogler(@NotNull @RequestBody GooglerRegisterRequest googlerRegisterRequest) {
        try {
            GooglerDTO googlerDTO = googlerService.registerGoogler(googlerRegisterRequest);
            return Response.create("Created Googler", HttpStatus.OK, googlerDTO);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
