package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.edu.gateway.domain.Account;
import com.nhnacademy.edu.gateway.domain.Project;
import com.nhnacademy.edu.gateway.domain.ProjectCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProjectAdaptorImpl implements ProjectAdaptor {

    private final RestTemplate restTemplate;

    private final TaskAdaptorProperties taskAdaptorProperties;

    @Override
    public List<Project> getProjects(String userName) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<Project>> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/projects/{userName}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<Project>>() {
                },userName);
        return exchange.getBody();
    }

    @Override
    public Project getProject(Long projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Project> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress()+"/projects/{projectName}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<Project>() {
                },projectId);
        return exchange.getBody();
    }

    @Override
    public void createProject(ProjectCreate projectCreate) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<ProjectCreate> requestEntity = new HttpEntity<>(projectCreate, httpHeaders);
        ResponseEntity<ProjectCreate> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress()+"/projects",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
        exchange.getBody();
    }

    @Override
    public void deleteProject(Long projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

        restTemplate.exchange(taskAdaptorProperties.getAddress() + "/projects/{projectId}",
                HttpMethod.DELETE,
                requestEntity,
                Void.class,
                projectId);
    }
}
