package com.example.zemoga;


import com.example.zemoga.DTO.BriefcaseDTO;
import com.example.zemoga.models.Briefcase;
import com.example.zemoga.repositories.BriefcaseRepository;
import com.example.zemoga.services.BriefcaseServiceImplement;
import com.example.zemoga.utlis.TwitterConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BriefcaseServiceImplementTest {


    private BriefcaseRepository briefcaseRepository;
    private TwitterConnection twitterConnection;

    @BeforeEach
    public void init() {
        briefcaseRepository = mock(BriefcaseRepository.class);
        twitterConnection = mock(TwitterConnection.class);
        Briefcase briefcase = new Briefcase();
        briefcase.setId(1);
        when(briefcaseRepository.findById(1)).thenReturn(briefcase);
    }

    @Test
    public void getBriefcaseByIdExistTest() {
        BriefcaseServiceImplement briefcaseServiceImplement = new BriefcaseServiceImplement(briefcaseRepository, twitterConnection);
        BriefcaseDTO briefcaseDTO = briefcaseServiceImplement.getBriefcaseById(1);
        assertThat(briefcaseDTO.getId()).isEqualTo(1);
    }

    @Test
    public void getBriefcaseByIdDoesNotExistTest() {
        BriefcaseServiceImplement briefcaseServiceImplement = new BriefcaseServiceImplement(briefcaseRepository, twitterConnection);
        BriefcaseDTO briefcaseDTO = briefcaseServiceImplement.getBriefcaseById(2);
        assertThat(briefcaseDTO).isEqualTo(null);
    }

}
