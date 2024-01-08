package com.tolgaozgun.gdscturkweb.dto.user.register;

import com.tolgaozgun.gdscturkweb.enums.UserType;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeadRegister extends ExtraRegister{

    public LeadRegister(Long universityId) {
        super(UserType.LEAD);
        this.universityId = universityId;
    }

    @NotNull
    private Long universityId;


    // Not needed during register
//    @Nullable
//    private Long buddyTeamId;

}
