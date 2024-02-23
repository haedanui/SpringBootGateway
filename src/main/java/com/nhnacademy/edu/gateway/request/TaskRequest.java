package com.nhnacademy.edu.gateway.request;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    private Long taskNumber;
    private String taskState;
    private String taskTitle;
    private String taskContent;
    private Long projectId;
}
