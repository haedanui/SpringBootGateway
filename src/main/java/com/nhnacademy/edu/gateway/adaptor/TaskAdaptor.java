package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.domain.Tag;
import com.nhnacademy.edu.gateway.domain.Task;

import java.util.List;

public interface TaskAdaptor {
    List<Task> getTasks(Long projectId);

    Task getTasks(Long projectId, Long taskNumber);

    void createTask(Long projectId, Task task);

    void deleteTask(Long projectId, Long taskNumber);
}
