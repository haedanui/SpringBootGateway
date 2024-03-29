package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.edu.gateway.domain.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskAdaptorImpl implements TaskAdaptor{

    private final RestTemplate restTemplate;

    private final TaskAdaptorProperties taskAdaptorProperties;
    @Override
    public List<Task> getTasks(Long projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<Task>> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/projects/{projectId}/task",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<Task>>() {
                },projectId);
        return exchange.getBody();
    }

    @Override
    public Task getTasks(Long projectId, Long taskNumber) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Task> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress()+"/projects/projectId/task/{taskNumber}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<Task>() {
                },projectId, taskNumber);
        return exchange.getBody();
    }

    @Override
    public void createTask(Long projectId, Task task) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Task> requestEntity = new HttpEntity<>(task, httpHeaders);
        ResponseEntity<Task> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress()+"/projects/{projectId}/task",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }, projectId);
        exchange.getBody();
    }

    @Override
    public void deleteTask(Long projectId, Long taskNumber) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

        restTemplate.exchange(taskAdaptorProperties.getAddress() + "/projects/{projectId}/task/{taskNumber}",
                HttpMethod.DELETE,
                requestEntity,
                Void.class,
                projectId, taskNumber);
    }
}
