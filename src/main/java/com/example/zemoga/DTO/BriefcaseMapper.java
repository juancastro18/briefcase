package com.example.zemoga.DTO;

import com.example.zemoga.models.Briefcase;

public class BriefcaseMapper {

    public static final BriefcaseDTO toBriefcaseDTO(Briefcase briefcase) {
        return new BriefcaseDTO()
                .setId(briefcase.getId())
                .setPathImage(briefcase.getPathImage())
                .setName(briefcase.getName())
                .setLastName(briefcase.getLastName())
                .setDescription(briefcase.getDescription())
                .setUserTwitter(briefcase.getUserTwitter())
                ;
    }
}