package com.tolgaozgun.gdscturkweb.dto.request.invitation;

import com.tolgaozgun.gdscturkweb.dto.user.register.CoreTeamRegister;
import com.tolgaozgun.gdscturkweb.enums.UserType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InviteCoreTeamRequest {

    @NotNull
    private String email;


}
