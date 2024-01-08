package com.tolgaozgun.gdscturkweb.dto.response;

import com.tolgaozgun.gdscturkweb.dto.UserDTO;
import com.tolgaozgun.gdscturkweb.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcceptInvitationResponse {

    private String email;

    private UserType role;

    private UserDTO invitedBy;

}
