package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.edu.gateway.domain.Milestone;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MilestoneAdaptorImpl implements MilestoneAdaptor{

    private final RestTemplate restTemplate;

    private final TaskAdaptorProperties taskAdaptorProperties;

    @Override
    public List<Milestone> getMilestones() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<Milestone>> exchange = restTemplate.exchange(taskAdaptorProperties + "/milestones",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<Milestone>>() {
                });
        return exchange.getBody();
    }

    @Override
    public Milestone getMilestone(Long milestoneNumber) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Milestone> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress()+"/milestones/{milestoneNumber}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<Milestone>() {
                },milestoneNumber);
        return exchange.getBody();
    }

    @Override
    public void createMilestone(Milestone milestone) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Milestone> requestEntity = new HttpEntity<>(milestone, httpHeaders);
        ResponseEntity<Milestone> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress()+"/milestones",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
        exchange.getBody();
    }
}
