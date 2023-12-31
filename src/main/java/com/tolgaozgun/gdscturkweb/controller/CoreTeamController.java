package com.tolgaozgun.gdscturkweb.controller;

import com.tolgaozgun.gdscturkweb.dto.CoreTeamDTO;
import com.tolgaozgun.gdscturkweb.dto.CoreTeamMemberDTO;
import com.tolgaozgun.gdscturkweb.dto.request.register.CoreTeamRegisterRequest;
import com.tolgaozgun.gdscturkweb.dto.response.Response;
import com.tolgaozgun.gdscturkweb.exception.BaseException;
import com.tolgaozgun.gdscturkweb.exception.ExceptionLogger;
import com.tolgaozgun.gdscturkweb.service.CoreTeamMemberService;
import com.tolgaozgun.gdscturkweb.service.CoreTeamService;
import com.tolgaozgun.gdscturkweb.service.LeadService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("core-teams")
public class CoreTeamController {

    private final CoreTeamService coreTeamService;
    private final LeadService leadService;

    @GetMapping( path = "")
    public ResponseEntity<Object> getAllCoreTeams() {
        try {
            List<CoreTeamDTO> coreTeams = coreTeamService.getAllCoreTeams();
            return Response.create("Gathered all core teams", HttpStatus.OK, coreTeams);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(path = "current-lead")
    public ResponseEntity<Object> getCoreTeamByCurrentLead() {
        try {
            CoreTeamDTO coreTeam = leadService.getCoreTeamByCurrentLead();
            return Response.create("Gathered core team by lead", HttpStatus.OK, coreTeam);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping( path = "current-member")
    public ResponseEntity<Object> getCoreTeamByCurrentMember() {
        try {
            CoreTeamDTO coreTeamDTO = coreTeamService.getCoreTeamByCurrentCoreTeamMember();
            return Response.create("Gathered core team by member", HttpStatus.OK, coreTeamDTO);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping( path = "id/{coreTeamId}")
    public ResponseEntity<Object> getCoreTeamByCurrentMember(@PathVariable Long coreTeamId) {
        try {
            CoreTeamDTO coreTeamDTO = coreTeamService.getCoreTeamById(coreTeamId);
            return Response.create("Gathered core team by member", HttpStatus.OK, coreTeamDTO);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}