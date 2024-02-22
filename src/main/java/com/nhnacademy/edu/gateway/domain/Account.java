package com.nhnacademy.edu.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long accountId;
    private String userId;
    private String userPassword;
    private String userEmail;
    private String userName;
    private String userStatus;
}
