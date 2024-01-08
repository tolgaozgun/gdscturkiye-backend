package com.tolgaozgun.gdscturkweb.dto.user.register;

import com.tolgaozgun.gdscturkweb.enums.UserType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ExtraRegister {

    @NotNull
    private UserType userType;

    public ExtraRegister(UserType userType) {
        this.userType = userType;
    }

    public ExtraRegister() {
        this.userType = null;
    }



}
