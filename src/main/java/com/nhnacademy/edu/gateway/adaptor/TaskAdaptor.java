package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.domain.Task;

import java.util.List;

public interface TaskAdaptor {
    List<Task> getTasks();

    Task getTask(String projectName);

    void createTask(Task task);
}
