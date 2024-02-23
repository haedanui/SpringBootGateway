package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.domain.Tag;
import com.nhnacademy.edu.gateway.domain.Task;

import java.util.List;

public interface TaskAdaptor {
    List<Task> getTasks();

    Task getTasks(Long taskNumber);

    void createTask(Task task);
}
