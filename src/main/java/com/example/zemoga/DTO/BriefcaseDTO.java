package com.example.zemoga.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;
import twitter4j.Status;

import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
@Data
public class BriefcaseDTO {

    List<Status> twitters;
    private long id;
    private String pathImage;
    private String name;
    private String lastName;
    private String description;
    private String userTwitter;

}
