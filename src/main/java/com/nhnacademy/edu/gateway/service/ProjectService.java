package com.nhnacademy.edu.gateway.service;

import com.nhnacademy.edu.gateway.adaptor.ProjectAdaptor;
import com.nhnacademy.edu.gateway.domain.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectAdaptor projectAdaptor;

    public List<Project> getProjects() {
        return projectAdaptor.getProjects();
    }

    public Project getProject(String projectName) {
        return projectAdaptor.getProject(projectName);
    }

    public void createProject(Project project) {
        projectAdaptor.createProject(project);
    }
}
