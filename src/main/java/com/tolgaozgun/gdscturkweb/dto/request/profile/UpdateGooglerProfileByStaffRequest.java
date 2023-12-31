package com.tolgaozgun.gdscturkweb.dto.request.profile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tolgaozgun.gdscturkweb.dto.user.profile.UpdateGooglerProfileByStaff;
import com.tolgaozgun.gdscturkweb.dto.user.profile.UpdateUserProfileByStaff;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateGooglerProfileByStaffRequest {


    @NotNull
    @JsonProperty("googler")
    private UpdateGooglerProfileByStaff updateGooglerProfile;


}
