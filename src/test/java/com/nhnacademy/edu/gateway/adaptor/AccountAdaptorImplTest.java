package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.domain.Account;
import jdk.jfr.Enabled;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@Enabled
class AccountAdaptorImplTest {
    @Autowired
    AccountAdaptor accountAdaptor;

    @Test
    @Order(1)
    void testgetAccount() throws Exception {
        Account acutal = accountAdaptor.getAccount("admin");

        Assertions.assertThat(acutal.getUserId()).isEqualTo("admin");

    }

    @Test
    @Order(2)
    void testgetAccounts() throws Exception {
        List<Account> accountList = accountAdaptor.getAccounts();
        log.debug(accountList.get(0).getUserId());
        Assertions.assertThat(accountList.get(0).getUserId()).isEqualTo("admin");

    }
    @Test
    @Order(3)
    void testCreateAccount() throws Exception {
        Account account = new Account(1L, "test", "123", "test@nhn.com", "테스트", "가입");
        accountAdaptor.createAccount(account);

        Account acutal = accountAdaptor.getAccount("test");
        Assertions.assertThat(acutal.getUserId()).isEqualTo("test");

    }
}