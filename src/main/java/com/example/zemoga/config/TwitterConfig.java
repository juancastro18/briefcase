package com.example.zemoga.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class TwitterConfig {
    @Value("${twitter.key}")
    private String twitterKey;

    @Value("${twitter.secret.key}")
    private String twitterSecretKey;

    @Value("${twitter.token}")
    private String twitterToken;

    @Value("${twitter.secret.token}")
    private String twitterSecretToken;

    @Value("${twitter.limit}")
    private Integer limit;
}
