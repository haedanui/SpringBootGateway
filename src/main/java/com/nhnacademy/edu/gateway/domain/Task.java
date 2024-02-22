package com.nhnacademy.edu.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long projectId;
    private String projectName;
    private String projectState;
    private String projectAdmin;
}
