package com.nhnacademy.edu.gateway.service;

import com.nhnacademy.edu.gateway.adaptor.TaskAdaptor;
import com.nhnacademy.edu.gateway.domain.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskAdaptor taskAdaptor;

    public List<Task> getTasks() {
        return taskAdaptor.getTasks();
    }

    public Task getTask(String projectName) {
        return taskAdaptor.getTask(projectName);
    }

    public void createTask(Task task) {
        taskAdaptor.createTask(task);
    }
}
