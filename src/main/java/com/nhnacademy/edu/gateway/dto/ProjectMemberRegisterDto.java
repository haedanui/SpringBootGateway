package com.nhnacademy.edu.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProjectMemberRegisterDto {

    private String userName;
    private Long userNumber;
    private Long projectId;
    private Long projectNumber;
    private List<String> selectedUsers;
}
