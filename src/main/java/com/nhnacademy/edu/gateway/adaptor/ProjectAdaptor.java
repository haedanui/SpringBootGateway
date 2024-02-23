package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.domain.Project;

import java.util.List;

public interface ProjectAdaptor {
    List<Project> getProjects();

    Project getProject(String projectName);

    void createProject(Project project);
}
