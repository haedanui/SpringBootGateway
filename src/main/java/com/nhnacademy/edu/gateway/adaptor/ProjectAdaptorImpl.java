package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.edu.gateway.domain.Project;
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
    public List<Project> getProjects() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<Project>> exchange = restTemplate.exchange(taskAdaptorProperties + "/projects",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<Project>>() {
                });
        return exchange.getBody();
    }

    @Override
    public Project getProject(String projectName) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Project> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress()+"/projects/{projectName}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<Project>() {
                },projectName);
        return exchange.getBody();
    }

    @Override
    public void createProject(Project project) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Project> requestEntity = new HttpEntity<>(project, httpHeaders);
        ResponseEntity<Project> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress()+"/projects",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
        exchange.getBody();
    }
}
