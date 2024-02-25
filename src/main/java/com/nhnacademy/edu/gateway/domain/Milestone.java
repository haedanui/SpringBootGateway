package com.nhnacademy.edu.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Milestone {
    private Long milestoneNumber;
    private LocalDateTime dateStart;
    private LocalDateTime dateFinish;
    private Long projectId;
    private Long taskNumber;
}
