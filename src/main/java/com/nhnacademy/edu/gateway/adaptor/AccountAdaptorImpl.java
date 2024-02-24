package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.config.AccountAdaptorProperties;
import com.nhnacademy.edu.gateway.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountAdaptorImpl implements AccountAdaptor{

    private final RestTemplate restTemplate;

    private final AccountAdaptorProperties accountAdaptorProperties;
    @Override
    public List<Account> getAccounts() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<Account>> exchange = restTemplate.exchange(accountAdaptorProperties.getAddress() + "/accounts",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<Account>>() {
                });
        return exchange.getBody();
    }

    @Override
    public Account getAccount(String userId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Account> exchange = restTemplate.exchange(accountAdaptorProperties.getAddress()+"/accounts/{userId}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<Account>() {
                },userId);
        return exchange.getBody();
    }

    @Override
    public void createAccount(Account account) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Account> requestEntity = new HttpEntity<>(account, httpHeaders);
        ResponseEntity<Account> exchange = restTemplate.exchange(accountAdaptorProperties.getAddress()+"/accounts",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
        exchange.getBody();
    }
}
