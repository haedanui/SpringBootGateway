package com.nhnacademy.edu.gateway.service;

import com.nhnacademy.edu.gateway.adaptor.AccountAdaptor;
import com.nhnacademy.edu.gateway.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountAdaptor accountAdaptor;

    public List<Account> getAccounts(){
        return accountAdaptor.getAccounts();
    }

    public Account getAccount(String userId){
        return accountAdaptor.getAccount(userId);
    }

    public void createAccount(Account account) {
        accountAdaptor.createAccount(account);
    }
}
