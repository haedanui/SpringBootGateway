package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.domain.Milestone;

import java.util.List;

public interface MilestoneAdaptor {
    List<Milestone> getMilestones();

    Milestone getMilestone(Long milestoneNumber);

    void createMilestone(Milestone milestone);
}
