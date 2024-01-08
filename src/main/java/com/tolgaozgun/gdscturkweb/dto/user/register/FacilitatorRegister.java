package com.tolgaozgun.gdscturkweb.dto.user.register;

import com.tolgaozgun.gdscturkweb.enums.UserType;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class FacilitatorRegister extends ExtraRegister {

    public FacilitatorRegister(Long universityId) {
        super(UserType.FACILITATOR);
        this.universityId = universityId;
    }

    @NotNull
    private Long universityId;

}
