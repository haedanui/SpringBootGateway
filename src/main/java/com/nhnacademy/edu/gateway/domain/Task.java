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
    private String taskTitle;
    private String taskContent;
    private String taskState;
}
