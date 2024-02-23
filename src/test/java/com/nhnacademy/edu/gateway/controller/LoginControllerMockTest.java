package com.nhnacademy.edu.gateway.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.gateway.adaptor.AccountAdaptor;
import com.nhnacademy.edu.gateway.domain.Account;
import com.nhnacademy.edu.gateway.request.LoginRequest;
import jdk.jfr.Enabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Enabled
class LoginControllerMockTest {
    @MockBean
    AccountAdaptor accountAdaptor;

    @Autowired
    MockMvc mockMvc;

    @Test
    @Order(1)
    void testLogin() throws Exception {
        given(accountAdaptor.getAccount("관리자"))
                .willReturn(new Account(1L, "test", "123", "test@nhn.com", "테스트", "가입"));

        LoginRequest input = new LoginRequest("관리자","123");
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/login")
                        .content(objectMapper.writeValueAsString(input))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.TEXT_HTML + ";charset=UTF-8"))
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].userId", equalTo("test")));
    }
}