package com.nhnacademy.edu.gateway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class taskController {

    @GetMapping("/task")
    public String taskTest() {
        return "taskPage";
    }

    @GetMapping("/taskDetail")
    public String taskDetailTest() {
        return "taskDetailPage";
    }
}
