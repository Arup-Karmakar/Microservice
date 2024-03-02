package com.microservice.limitservice.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties("limit-service")
@Getter
@Setter
public class Config {
    private int minimum;
    private int maximum;
}
