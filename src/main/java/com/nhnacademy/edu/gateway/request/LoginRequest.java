package com.nhnacademy.edu.gateway.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String userId;

    private String userPassword;
}
