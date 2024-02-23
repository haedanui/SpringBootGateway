package com.nhnacademy.edu.gateway.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MilestoneRequset {
    private Long milestoneNumber;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private Long projectId;
    private Long taskNumber;
}
