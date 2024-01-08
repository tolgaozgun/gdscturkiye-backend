package com.tolgaozgun.gdscturkweb.controller;


import com.tolgaozgun.gdscturkweb.dto.*;
import com.tolgaozgun.gdscturkweb.dto.request.profile.*;
import com.tolgaozgun.gdscturkweb.dto.response.Response;
import com.tolgaozgun.gdscturkweb.exception.BaseException;
import com.tolgaozgun.gdscturkweb.exception.ExceptionLogger;
import com.tolgaozgun.gdscturkweb.model.user.Googler;
import com.tolgaozgun.gdscturkweb.service.ProfileService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("profile")
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "update/lead")
    public ResponseEntity<Object> updateLeadProfileByLead(@Valid @RequestBody UpdateLeadProfileByLeadRequest
                                                                      updateLeadProfileByLeadRequest) {
        try {
            LeadDTO leadDTO = profileService.updateLeadProfile(updateLeadProfileByLeadRequest);
            return Response.create("Update is successful", HttpStatus.OK, leadDTO);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "update/core-team")
    public ResponseEntity<Object> updateCoreTeamProfileByCore(@Valid @RequestBody UpdateCoreTeamMemberProfileByMemberRequest
                                                                  updateCoreTeamMemberProfileByMemberRequest) {
        try {
            CoreTeamMemberDTO coreTeamMemberDTO = profileService.updateCoreTeamMemberProfile(updateCoreTeamMemberProfileByMemberRequest);
            return Response.create("Update is successful", HttpStatus.OK, coreTeamMemberDTO);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "update/facilitator")
    public ResponseEntity<Object> updateFacilitatorProfile(@Valid @RequestBody UpdateFacilitatorProfileByFacilitatorRequest
                                                                   updateFacilitatorProfileByFacilitatorRequest) {
        try {
            FacilitatorDTO facilitatorDTO = profileService.updateFacilitatorProfile(updateFacilitatorProfileByFacilitatorRequest);
            return Response.create("Update is successful", HttpStatus.OK, facilitatorDTO);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "update/googler")
    public ResponseEntity<Object> updateGooglerProfile(@Valid @RequestBody UpdateGooglerProfileByGooglerRequest
                                                                   updateGooglerProfileByGooglerRequest) {
        try {
            GooglerDTO googlerDTO = profileService.updateGooglerProfile(updateGooglerProfileByGooglerRequest);
            return Response.create("Update is successful", HttpStatus.OK, googlerDTO);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "update/user")
    public ResponseEntity<Object> updateUserProfile(@Valid @RequestBody UpdateUserProfileByUserRequest
                                                                   updateUserProfileByUserRequest) {
        try {
            UserDTO userDTO = profileService.updateUserProfileByUser(updateUserProfileByUserRequest);
            return Response.create("Update is successful", HttpStatus.OK, userDTO);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "update-staff/lead/{leadId}")
    public ResponseEntity<Object> updateLeadProfileByStaff(@Valid @PathVariable Long leadId,
                                                           @Valid @RequestBody UpdateLeadProfileByStaffRequest
                                                                  updateLeadProfileByStaffRequest) {
        try {
            LeadDTO leadDTO = profileService.updateLeadProfileByStaff(leadId, updateLeadProfileByStaffRequest);
            return Response.create("Update is successful", HttpStatus.OK, leadDTO);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "update-staff/core-team/{coreTeamMemberId}")
    public ResponseEntity<Object> updateCoreTeamProfileByStaff(@Valid @PathVariable Long coreTeamMemberId,
                                                               @Valid @RequestBody UpdateCoreTeamMemberProfileByStaffRequest
                                                                      updateCoreTeamMemberProfileByStaffRequest) {
        try {
            CoreTeamMemberDTO coreTeamMemberDTO = profileService.updateCoreTeamMemberProfileByStaff(coreTeamMemberId,
                    updateCoreTeamMemberProfileByStaffRequest);
            return Response.create("Update is successful", HttpStatus.OK, coreTeamMemberDTO);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "update-staff/facilitator/{facilitatorId}")
    public ResponseEntity<Object> updateFacilitatorProfileByStaff(@Valid @PathVariable Long facilitatorId,
                                                                  @Valid @RequestBody UpdateFacilitatorProfileByStaffRequest
                                                                   updateFacilitatorProfileByStaffRequest) {
        try {
            FacilitatorDTO facilitatorDTO = profileService.updateFacilitatorProfileByStaff(facilitatorId,
                    updateFacilitatorProfileByStaffRequest);
            return Response.create("Update is successful", HttpStatus.OK, facilitatorDTO);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "update-staff/googler/{googlerId}")
    public ResponseEntity<Object> updateGooglerProfileByStaff(@Valid @PathVariable Long googlerId,
                                                              @Valid @RequestBody UpdateGooglerProfileByStaffRequest
                                                                  updateGooglerProfileByStaffRequest) {
        try {
            GooglerDTO googlerDTO = profileService.updateGooglerProfileByStaff(googlerId,
                    updateGooglerProfileByStaffRequest);
            return Response.create("Update is successful", HttpStatus.OK, googlerDTO);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "update-staff/user/{userId}")
    public ResponseEntity<Object> updateUserProfileByStaff(@Valid @PathVariable Long userId,
                                                           @Valid @RequestBody UpdateUserProfileByStaffRequest
                                                                      updateUserProfileByStaffRequest) {
        try {
            UserDTO userDTO = profileService.updateUserProfileByStaff(userId,
                    updateUserProfileByStaffRequest);
            return Response.create("Update is successful", HttpStatus.OK, userDTO);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
