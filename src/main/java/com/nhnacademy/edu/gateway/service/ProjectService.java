package com.nhnacademy.edu.gateway.service;

import com.nhnacademy.edu.gateway.adaptor.ProjectAdaptor;
import com.nhnacademy.edu.gateway.domain.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectAdaptor taskAdaptor;

    public List<Project> getTasks() {
        return taskAdaptor.getProjects();
    }

    public Project getTask(String projectName) {
        return taskAdaptor.getProject(projectName);
    }

    public void createTask(Project project) {
        taskAdaptor.createProject(project);
    }
}
