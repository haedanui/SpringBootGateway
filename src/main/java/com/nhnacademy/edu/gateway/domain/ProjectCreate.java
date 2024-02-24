package com.nhnacademy.edu.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectCreate {
    private Long projectId;
    private Long userNumber;
    private String projectName;
    private String projectAdmin;
}
