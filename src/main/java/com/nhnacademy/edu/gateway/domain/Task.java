package com.nhnacademy.edu.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long taskNumber;
    private String taskState;
    private String taskTitle;
    private String taskContent;
    private Long projectId;
}
