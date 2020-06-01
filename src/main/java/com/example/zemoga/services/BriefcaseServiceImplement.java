package com.example.zemoga.services;

import com.example.zemoga.DTO.BriefcaseDTO;
import com.example.zemoga.DTO.BriefcaseMapper;
import com.example.zemoga.models.Briefcase;
import com.example.zemoga.repositories.BriefcaseRepository;
import com.example.zemoga.utlis.TwitterConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Status;

import java.util.List;

@Service
public class BriefcaseServiceImplement implements BriefcaseService {

    private final BriefcaseRepository briefcaseRepository;
    private final TwitterConnection twitterConnection;

    @Autowired
    public BriefcaseServiceImplement(BriefcaseRepository briefcaseRepository,
                                     TwitterConnection twitterConnection) {
        this.briefcaseRepository = briefcaseRepository;
        this.twitterConnection = twitterConnection;
    }

    @Override
    public BriefcaseDTO getBriefcaseById(long id) {
        Briefcase briefcase = briefcaseRepository.findById(id);
        if (briefcase == null) return null;
        BriefcaseDTO briefcaseDTO = BriefcaseMapper.toBriefcaseDTO(briefcase);
        List<Status> statuses = twitterConnection.getTimelineUSer(briefcase.getUserTwitter());
        briefcaseDTO.setTwitters(statuses);
        return briefcaseDTO;
    }

    @Override
    public Briefcase updateBriefcase(Briefcase briefcase) {
        Briefcase briefcaseFind = briefcaseRepository.findById(briefcase.getId());
        if (briefcaseFind == null) return null;
        return briefcaseRepository.save(briefcase);
    }
}
