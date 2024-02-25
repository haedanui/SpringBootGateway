package com.nhnacademy.edu.gateway.request;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequest {
    private long projectNumber;
    private String projectName;
}
