package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.edu.gateway.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentAdaptorImpl implements CommentAdaptor{

    private final RestTemplate restTemplate;

    private final TaskAdaptorProperties taskAdaptorProperties;
    @Override
    public List<Comment> getComments() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<Comment>> exchange = restTemplate.exchange(taskAdaptorProperties + "/comments",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<Comment>>() {
                });
        return exchange.getBody();
    }

    @Override
    public Comment getComment(Long commentNumber) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Comment> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress()+"/comments/{commentNumber}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<Comment>() {
                },commentNumber);
        return exchange.getBody();
    }

    @Override
    public void createComment(Comment comment) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Comment> requestEntity = new HttpEntity<>(comment, httpHeaders);
        ResponseEntity<Comment> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress()+"/comments",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
        exchange.getBody();
    }
}
