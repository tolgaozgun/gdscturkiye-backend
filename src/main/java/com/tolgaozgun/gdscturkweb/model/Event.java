package com.tolgaozgun.gdscturkweb.model;

import com.tolgaozgun.gdscturkweb.entity.UniversityEntity;
import com.tolgaozgun.gdscturkweb.entity.TopicEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    private Long eventId;

    @NotNull
    private List<University> organizers;

    @NotNull
    private String title;

    @NotNull
    private String address;

    @Nullable
    private String description;

    @NotNull
    private Date startDate;

    @Nullable
    private Date endDate;

    @NotNull
    private String link;

    @NotNull
    private List<Topic> topics;
}
