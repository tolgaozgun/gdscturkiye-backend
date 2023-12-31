package com.tolgaozgun.gdscturkweb.controller;

import com.tolgaozgun.gdscturkweb.dto.CoreTeamMemberDTO;
import com.tolgaozgun.gdscturkweb.dto.FacilitatorDTO;
import com.tolgaozgun.gdscturkweb.dto.LeadDTO;
import com.tolgaozgun.gdscturkweb.dto.request.register.CoreTeamRegisterRequest;
import com.tolgaozgun.gdscturkweb.dto.request.register.FacilitatorRegisterRequest;
import com.tolgaozgun.gdscturkweb.dto.response.FacilitatorDashboardResponse;
import com.tolgaozgun.gdscturkweb.dto.response.LeadDashboardResponse;
import com.tolgaozgun.gdscturkweb.dto.response.Response;
import com.tolgaozgun.gdscturkweb.exception.BaseException;
import com.tolgaozgun.gdscturkweb.exception.ExceptionLogger;
import com.tolgaozgun.gdscturkweb.service.FacilitatorService;
import com.tolgaozgun.gdscturkweb.service.LeadService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("facilitators")
public class FacilitatorController {

    private final FacilitatorService facilitatorService;

    @GetMapping( path = "")
    public ResponseEntity<Object> getAllFacilitators() {
        try {
            List<FacilitatorDTO> facilitatorList = facilitatorService.getAllFacilitators();
            return Response.create("Gathered all facilitators", HttpStatus.OK, facilitatorList);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping( path = "dashboard")
    public ResponseEntity<Object> getCurrentFacilitatorDashboard() {
        try {
            FacilitatorDashboardResponse facilitatorDashboardResponse = facilitatorService.getCurrentFacilitatorDashboard();
            return Response.create("Gathered current facilitator dashboard", HttpStatus.OK, facilitatorDashboardResponse);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping( path = "create")
    public ResponseEntity<Object> createFacilitator(@NotNull @RequestBody FacilitatorRegisterRequest facilitatorRegisterRequest) {
        try {
            FacilitatorDTO facilitatorDTO = facilitatorService.registerFacilitator(facilitatorRegisterRequest);
            return Response.create("Created facilitator", HttpStatus.OK, facilitatorDTO);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
