package com.tolgaozgun.gdscturkweb.service;


import com.tolgaozgun.gdscturkweb.dto.CoreTeamDTO;
import com.tolgaozgun.gdscturkweb.dto.LeadDTO;
import com.tolgaozgun.gdscturkweb.dto.request.coreTeam.InviteCoreTeamRequest;
import com.tolgaozgun.gdscturkweb.dto.request.register.LeadRegisterRequest;
import com.tolgaozgun.gdscturkweb.dto.response.LeadDashboardResponse;
import com.tolgaozgun.gdscturkweb.dto.user.register.LeadRegister;
import com.tolgaozgun.gdscturkweb.dto.user.register.UserRegister;
import com.tolgaozgun.gdscturkweb.entity.BuddyTeamEntity;
import com.tolgaozgun.gdscturkweb.entity.CoreTeamEntity;
import com.tolgaozgun.gdscturkweb.entity.UniversityEntity;
import com.tolgaozgun.gdscturkweb.entity.user.CoreTeamMemberEntity;
import com.tolgaozgun.gdscturkweb.entity.user.LeadEntity;
import com.tolgaozgun.gdscturkweb.entity.user.UserEntity;
import com.tolgaozgun.gdscturkweb.enums.UserType;
import com.tolgaozgun.gdscturkweb.exception.LeadNotFoundException;
import com.tolgaozgun.gdscturkweb.mapper.LeadMapper;
import com.tolgaozgun.gdscturkweb.mapper.UniversityMapper;
import com.tolgaozgun.gdscturkweb.model.Event;
import com.tolgaozgun.gdscturkweb.model.LeadAttendance;
import com.tolgaozgun.gdscturkweb.repository.UniversityRepository;
import com.tolgaozgun.gdscturkweb.repository.user.CoreTeamMemberRepository;
import com.tolgaozgun.gdscturkweb.repository.user.LeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class LeadService {

    private final LeadRepository leadRepository;
    private final UniversityRepository universityRepository;
    private final CoreTeamMemberRepository coreTeamMemberRepository;


    private final LeadMapper leadMapper;

    private final AuthService authService;
    private final AttendanceService attendanceService;
    private final CoreTeamService coreTeamService;

    public List<LeadDTO> getAllLeads() {
        try {
            List<LeadEntity> leadEntities = leadRepository.findAll();
            return leadMapper.toDTO(leadEntities);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public CoreTeamDTO getCoreTeamByCurrentLead() {
        try {

            UserEntity userEntity = authService.getCurrentUserEntity();
            LeadEntity leadEntity = getLeadEntityFromUserEntity(userEntity);
            return coreTeamService.getCoreTeamByCurrentLead(leadEntity);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }


    protected LeadEntity getLeadEntityFromUserEntity(UserEntity userEntity) {
        try {
            Optional<LeadEntity> optionalLeadEntity = leadRepository.findByUser(userEntity);
            if (optionalLeadEntity.isEmpty()) {
                throw new LeadNotFoundException();
            }
            return optionalLeadEntity.get();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    public void inviteCoreTeamMember(InviteCoreTeamRequest inviteCoreTeamRequest) throws Exception {
        try {

            UserEntity userEntity = authService.getCurrentUserEntity();

            if (userEntity.getUserType() != UserType.LEAD) {
                throw new Exception("Only lead can invite core team member");
            }

            LeadEntity leadEntity = getLeadEntityFromUserEntity(userEntity);

            UniversityEntity universityEntity = leadEntity.getUniversity();

            if (universityEntity == null) {
                throw new Exception("Lead has no university");
            }


            String email = inviteCoreTeamRequest.getEmail();


        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }


    public LeadDTO registerLead(LeadRegisterRequest leadRegisterRequest) throws Exception {
        try {

            UserRegister userRegister = leadRegisterRequest.getUserRegister();
            LeadRegister leadRegister = leadRegisterRequest.getLeadRegister();

            UserEntity savedEntity = authService.checkAndRegisterUser(userRegister, UserType.LEAD);


            UniversityEntity universityEntity = universityRepository.findById(leadRegister.getUniversityId())
                    .orElseThrow(() -> new Exception("University not found"));

            if (leadRepository.existsLeadEntityByUniversity(universityEntity)) {
                throw new Exception("University already has a lead");
            }

            LeadEntity leadEntity = new LeadEntity(universityEntity, savedEntity);

            LeadEntity savedLeadEntity = leadRepository.save(leadEntity);

            coreTeamService.createCoreTeam(savedLeadEntity);


            return leadMapper.toDTO(savedLeadEntity);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public LeadDashboardResponse getCurrentLeadDashboard(){
       try {
           UserEntity userEntity = authService.getCurrentUserEntity();

           Optional<LeadEntity> optionalLeadEntity = leadRepository.findByUser(userEntity);

           if (optionalLeadEntity.isEmpty()) {
               throw new LeadNotFoundException();
           }

           LeadEntity leadEntity = optionalLeadEntity.get();
           Integer buddyTeamSize = null;
           if (leadEntity.getBuddyTeam() != null) {
               BuddyTeamEntity buddyTeamEntity = leadEntity.getBuddyTeam();
               buddyTeamSize = buddyTeamEntity.getLeads().size();
           }

           UniversityEntity universityEntity = leadEntity.getUniversity();

           List<CoreTeamMemberEntity> coreTeamMemberEntities = coreTeamMemberRepository.findAllByUniversity(universityEntity);
           int coreTeamSize = coreTeamMemberEntities.size();

           LeadDashboardResponse leadDashboardResponse = new LeadDashboardResponse();
           leadDashboardResponse.setLeadDTO(leadMapper.toDTO(leadEntity));
           leadDashboardResponse.setBuddyTeamSize(buddyTeamSize);
           leadDashboardResponse.setCoreTeamSize(coreTeamSize);

           List<LeadAttendance> leadAttendances = attendanceService.getAttendancesByLeadEntity(leadEntity);

           // Create Map<Date,Boolean> using leadAttendances.getAttendanceDate() and leadAttendances.getAttendanceStatus()
           Map<Date, Boolean> buddyMeetings = new HashMap<>();
           for (LeadAttendance leadAttendance : leadAttendances) {
               buddyMeetings.put(leadAttendance.getAttendanceDate(), leadAttendance.getAttendanceStatus());
           }
           leadDashboardResponse.setBuddyMeetings(buddyMeetings);

           leadDashboardResponse.setPromotedAt(userEntity.getPromotedAt());

           return leadDashboardResponse;
       } catch (Exception e) {
           e.printStackTrace();
           throw e;
       }
    }

}
