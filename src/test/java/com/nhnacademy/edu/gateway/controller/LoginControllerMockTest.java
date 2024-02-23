package com.nhnacademy.edu.gateway.controller;

import com.nhnacademy.edu.gateway.adaptor.AccountAdaptor;
import com.nhnacademy.edu.gateway.domain.Account;
import jdk.jfr.Enabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
        given(accountAdaptor.getAccounts())
                .willReturn(List.of(new Account(1L, "test", "123", "test@nhn.com", "테스트", "가입")));

        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.TEXT_HTML + ";charset=UTF-8"))
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("loginForm"));
//                .andExpect(jsonPath("$[0].userId", equalTo("test")));
    }
}