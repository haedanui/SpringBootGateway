package com.nhnacademy.edu.gateway.domain;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long accountId;
    private String userId;
    private String userPassword;
    private String userEmail;
    private String userName;
    private String userState;
}
