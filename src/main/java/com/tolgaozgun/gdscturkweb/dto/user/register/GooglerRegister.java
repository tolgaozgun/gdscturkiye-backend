package com.tolgaozgun.gdscturkweb.dto.user.register;

import com.tolgaozgun.gdscturkweb.enums.UserType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
public class GooglerRegister extends ExtraRegister {

    public GooglerRegister() {
        super(UserType.GOOGLER);
    }


//    @NotNull
//    private UserRegister user;


}
