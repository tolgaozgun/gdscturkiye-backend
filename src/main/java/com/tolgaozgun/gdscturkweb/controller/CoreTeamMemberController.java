package com.tolgaozgun.gdscturkweb.controller;

import com.tolgaozgun.gdscturkweb.dto.CoreTeamMemberDTO;
import com.tolgaozgun.gdscturkweb.dto.LeadDTO;
import com.tolgaozgun.gdscturkweb.dto.request.coreTeam.InviteCoreTeamRequest;
import com.tolgaozgun.gdscturkweb.dto.request.register.CoreTeamRegisterRequest;
import com.tolgaozgun.gdscturkweb.dto.request.register.LeadRegisterRequest;
import com.tolgaozgun.gdscturkweb.dto.response.CoreTeamMemberDashboardResponse;
import com.tolgaozgun.gdscturkweb.dto.response.LeadDashboardResponse;
import com.tolgaozgun.gdscturkweb.dto.response.Response;
import com.tolgaozgun.gdscturkweb.exception.BaseException;
import com.tolgaozgun.gdscturkweb.exception.ExceptionLogger;
import com.tolgaozgun.gdscturkweb.service.CoreTeamMemberService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("core-team-members")
public class CoreTeamMemberController {

    private final CoreTeamMemberService coreTeamMemberService;

    @GetMapping( path = "")
    public ResponseEntity<Object> getAllCoreTeamMembers() {
        try {
            List<CoreTeamMemberDTO> coreTeamMembers = coreTeamMemberService.getAllCoreTeamMembers();
            return Response.create("Gathered all core team members", HttpStatus.OK, coreTeamMembers);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping( consumes = MediaType.APPLICATION_JSON_VALUE, path = "/by-university/{universityId}")
    public ResponseEntity<Object> getAllCoreTeamMembersByUniversity(@PathVariable Long universityId) {
        try {
            List<CoreTeamMemberDTO> coreTeamMembers = coreTeamMemberService.getAllCoreTeamMembersByUniversity(universityId);
            return Response.create("Gathered all core team members", HttpStatus.OK, coreTeamMembers);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping( path = "create")
    public ResponseEntity<Object> createCoreTeamMember(@NotNull @RequestBody CoreTeamRegisterRequest coreTeamRegisterRequest) {
        try {
            CoreTeamMemberDTO coreTeamMemberDTO = coreTeamMemberService.registerCoreTeam(coreTeamRegisterRequest);
            return Response.create("Created core team member", HttpStatus.OK, coreTeamMemberDTO);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping( path = "dashboard")
    public ResponseEntity<Object> getCurrentLeadDashboard() {
        try {
            CoreTeamMemberDashboardResponse coreTeamMemberDashboardResponse = coreTeamMemberService.getCurrentDashboard();
            return Response.create("Gathered current core team member dashboard", HttpStatus.OK, coreTeamMemberDashboardResponse);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
//    @PostMapping( path = "invite")
//    public ResponseEntity<Object> inviteCoreTeamMember(@NotNull @RequestBody InviteCoreTeamRequest inviteCoreTeamRequest) {
//        try {
//            CoreTeamMemberDTO coreTeamMemberDTO = coreTeamMemberService.registerCoreTeam(inviteCoreTeamRequest);
//            return Response.create("Invited core team member", HttpStatus.OK, coreTeamMemberDTO);
//        } catch (Exception e) {
//            // HTTP 500
//            return Response.create(ExceptionLogger.log(e), HttpStatus.OK);//        }
//    }


}
