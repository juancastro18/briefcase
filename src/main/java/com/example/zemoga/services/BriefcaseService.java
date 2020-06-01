package com.example.zemoga.services;

import com.example.zemoga.DTO.BriefcaseDTO;
import com.example.zemoga.models.Briefcase;

public interface BriefcaseService {

    BriefcaseDTO getBriefcaseById(long id);

    Briefcase updateBriefcase(Briefcase briefcase);
}
