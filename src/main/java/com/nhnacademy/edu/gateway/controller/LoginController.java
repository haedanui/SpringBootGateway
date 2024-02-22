package com.nhnacademy.edu.gateway.controller;

import com.nhnacademy.edu.gateway.domain.Account;
import com.nhnacademy.edu.gateway.request.LoginRequest;
import com.nhnacademy.edu.gateway.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final AccountService accountService;
    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginRequest",new LoginRequest());
        return "loginForm";
    }

    @PostMapping(value = "/login")
    public String doLogin(Model model, LoginRequest loginRequest, HttpSession session){
        Account account = accountService.getAccount(loginRequest.getUserId());
        if(account.getUserId().equals(loginRequest.getUserId()) &&
        account.getUserPassword().equals(loginRequest.getUserPassword())){
            session.setAttribute("loginUserInfo", loginRequest);
            return "main";

        }else{
            model.addAttribute("loginFail","로그인 실패");
            return "loginForm";
        }

    }

}