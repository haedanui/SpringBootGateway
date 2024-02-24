package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.edu.gateway.domain.ProjectMember;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProjectMemberAdaptorImpl implements ProjectMemberAdaptor{

    private final RestTemplate restTemplate;

    private final TaskAdaptorProperties taskAdaptorProperties;


    @Override
    public List<ProjectMember> getProjectMembers(String userName) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<ProjectMember>> exchange = restTemplate.exchange(taskAdaptorProperties + "/projectMembers",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<ProjectMember>>() {
                }, userName);
        return exchange.getBody();
    }

    @Override
    public ProjectMember getProjectMember(String userName) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<ProjectMember> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress()+"/projectMembers/{userName}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<ProjectMember>() {
                },userName);
        return exchange.getBody();
    }

    @Override
    public void createProjectMember(ProjectMember projectMember) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<ProjectMember> requestEntity = new HttpEntity<>(projectMember, httpHeaders);
        ResponseEntity<ProjectMember> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress()+"/projectMembers",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
        exchange.getBody();
    }
}
