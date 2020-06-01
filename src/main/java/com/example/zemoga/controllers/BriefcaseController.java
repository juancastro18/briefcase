package com.example.zemoga.controllers;

import com.example.zemoga.DTO.BriefcaseDTO;
import com.example.zemoga.models.Briefcase;
import com.example.zemoga.services.BriefcaseService;
import com.example.zemoga.services.BriefcaseServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/briefcase")
@CrossOrigin(origins = "*")
public class BriefcaseController {

    private final BriefcaseService briefcaseService;

    @Autowired
    public BriefcaseController(BriefcaseServiceImplement briefcaseService) {
        this.briefcaseService = briefcaseService;
    }

    @GetMapping(path = "/{id}")
    private @ResponseBody
    ResponseEntity<BriefcaseDTO> getBriefCase(@PathVariable long id) {
        BriefcaseDTO briefcaseDTO = briefcaseService.getBriefcaseById(id);
        if (briefcaseDTO != null)
            return new ResponseEntity<>(briefcaseDTO, HttpStatus.OK);
        else
            return new ResponseEntity<>(briefcaseDTO, null, HttpStatus.NOT_FOUND);

    }

    @PostMapping(path = "/update")
    private @ResponseBody
    ResponseEntity<Briefcase> updateBriefCase(@Validated @RequestBody Briefcase briefcase) {
        Briefcase briefcaseResponse = briefcaseService.updateBriefcase(briefcase);
        if (briefcaseResponse != null)
            return new ResponseEntity<>(briefcaseResponse, HttpStatus.OK);
        else
            return new ResponseEntity<>(briefcaseResponse, null, HttpStatus.NOT_FOUND);

    }

}
