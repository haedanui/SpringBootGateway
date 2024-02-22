package com.nhnacademy.edu.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dooray.account")
@Data
public class AccountAdaptorProperties {
    private String address;
}
