package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.domain.Account;

import java.util.List;

public interface AccountAdaptor {
    List<Account> getAccounts();
    Account getAccount(String userId);

    void createAccount(Account account);
}
