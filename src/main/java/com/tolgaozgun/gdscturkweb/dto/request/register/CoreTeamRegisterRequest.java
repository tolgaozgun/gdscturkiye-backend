package com.tolgaozgun.gdscturkweb.dto.request.register;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tolgaozgun.gdscturkweb.dto.user.register.CoreTeamRegister;
import com.tolgaozgun.gdscturkweb.dto.user.register.UserRegister;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoreTeamRegisterRequest {

    @NotNull
    @JsonProperty("user")
    private UserRegister userRegister;

    @NotNull
    @JsonProperty("coreTeam")
    private CoreTeamRegister coreTeamRegister;
}
