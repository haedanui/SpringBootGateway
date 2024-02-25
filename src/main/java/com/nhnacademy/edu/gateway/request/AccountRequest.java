package com.nhnacademy.edu.gateway.request;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {

    private String userId;

    private String userPassword;

    private String userEmail;

    private String userName;

    private String userState;
}
