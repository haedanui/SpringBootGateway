package com.nhnacademy.edu.gateway.controller;

import com.nhnacademy.edu.gateway.adaptor.AccountAdaptor;
import com.nhnacademy.edu.gateway.domain.Account;
import com.nhnacademy.edu.gateway.request.AccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    private final AccountAdaptor accountAdaptor;
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("accountRequest",new AccountRequest());
        return "registerForm";
    }

    @PostMapping(value = "/register")
    public String doRegister(Model model, AccountRequest accountRequest, HttpSession session){
        Account checkAccount = accountAdaptor.getAccount(accountRequest.getUserId());
        if(checkAccount == null) {
            Account account = new Account(1L, accountRequest.getUserId(), accountRequest.getUserPassword(),
                    accountRequest.getUserEmail(), accountRequest.getUserName(), accountRequest.getUserState());
            accountAdaptor.createAccount(account);
//            return "main";

            model.addAttribute("message", "회원가입 성공!");
            model.addAttribute("searchUrl", "/");
            return "alert";
        } else {
//            model.addAttribute("registerFail","회원가입 실패");
//            return "registerForm";
            model.addAttribute("message", "이미 존재하는 아이디입니다.");
            model.addAttribute("searchUrl", "/register");
            return "alert";
        }

    }
}