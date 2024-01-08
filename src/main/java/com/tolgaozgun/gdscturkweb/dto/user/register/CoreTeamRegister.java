package com.tolgaozgun.gdscturkweb.dto.user.register;

import com.tolgaozgun.gdscturkweb.enums.UserType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CoreTeamRegister extends ExtraRegister {

    public CoreTeamRegister() {
        super(UserType.CORE_TEAM_MEMBER);
    }


    @NotNull
    private Long universityId;


}
