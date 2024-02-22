package com.nhnacademy.edu.gateway.controller;

import com.nhnacademy.edu.gateway.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginFormController {
    @GetMapping("/")
    public String loginForm(Model model) {
        model.addAttribute("account");
        return "loginForm";
    }
}
