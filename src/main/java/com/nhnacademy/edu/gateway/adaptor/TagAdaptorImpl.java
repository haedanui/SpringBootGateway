package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.edu.gateway.domain.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TagAdaptorImpl implements TagAdaptor{

    private final RestTemplate restTemplate;

    private final TaskAdaptorProperties taskAdaptorProperties;

    @Override
    public List<Tag> getTags() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<Tag>> exchange = restTemplate.exchange(taskAdaptorProperties + "/tags",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<Tag>>() {
                });
        return exchange.getBody();
    }

    @Override
    public Tag getTag(String tagName) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Tag> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress()+"/tags/{tagName}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<Tag>() {
                },tagName);
        return exchange.getBody();
    }

    @Override
    public void createTag(Tag tag) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Tag> requestEntity = new HttpEntity<>(tag, httpHeaders);
        ResponseEntity<Tag> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress()+"/tags",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
        exchange.getBody();
    }
}
