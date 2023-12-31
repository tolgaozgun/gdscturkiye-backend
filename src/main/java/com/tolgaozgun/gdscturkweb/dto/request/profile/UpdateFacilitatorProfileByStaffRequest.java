package com.tolgaozgun.gdscturkweb.dto.request.profile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tolgaozgun.gdscturkweb.dto.user.profile.UpdateFacilitatorProfileByFacilitator;
import com.tolgaozgun.gdscturkweb.dto.user.profile.UpdateFacilitatorProfileByStaff;
import com.tolgaozgun.gdscturkweb.dto.user.profile.UpdateUserProfileByStaff;
import com.tolgaozgun.gdscturkweb.dto.user.profile.UpdateUserProfileByUser;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateFacilitatorProfileByStaffRequest {


    @NotNull
    @JsonProperty("facilitator")
    private UpdateFacilitatorProfileByStaff updateFacilitatorProfile;
}
