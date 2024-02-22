package com.nhnacademy.edu.gateway.controller;

import com.nhnacademy.edu.gateway.domain.Account;
import com.nhnacademy.edu.gateway.request.AccountRequest;
import com.nhnacademy.edu.gateway.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    private final AccountService accountService;
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("accountRequest",new AccountRequest());
        return "registerForm";
    }

    @PostMapping(value = "/register")
    public String doRegister(Model model, AccountRequest accountRequest, HttpSession session){
        Account checkAccount = accountService.getAccount(accountRequest.getUserId());
        if(checkAccount == null) {
            Account account = new Account(1L, accountRequest.getUserId(), accountRequest.getUserPassword(),
                    accountRequest.getUserEmail(), accountRequest.getUserName(), accountRequest.getUserState());
            accountService.createAccount(account);
            return "main";
        }else {
            model.addAttribute("registerFail","회원가입 실패");
            return "registerForm";
        }

    }
}