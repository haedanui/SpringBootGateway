package com.nhnacademy.edu.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dooray.task")
@Data
public class TaskAdaptorProperties {
    private String address;
}
