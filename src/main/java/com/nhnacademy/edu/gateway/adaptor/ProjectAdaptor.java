package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.domain.Project;
import com.nhnacademy.edu.gateway.domain.ProjectCreate;

import java.util.List;

public interface ProjectAdaptor {
    List<Project> getProjects(String userName);

    Project getProject(Long projectId);

    void createProject(ProjectCreate projectCreate);
}
