package com.nhnacademy.edu.gateway.request;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequest {
    private String projectNumber;
    private String projectName;
    private String projectState;
    private String projectAdmin;
}
