package com.nhnacademy.edu.gateway.controller;

import com.nhnacademy.edu.gateway.request.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String goMain(Model model) {
        return "main";
    }
}
