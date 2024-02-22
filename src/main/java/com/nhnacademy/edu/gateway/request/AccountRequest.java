package com.nhnacademy.edu.gateway.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequest {

    private String userId;

    private String userPassword;

    private String userEmail;

    private String userName;

    private String userState;
}
