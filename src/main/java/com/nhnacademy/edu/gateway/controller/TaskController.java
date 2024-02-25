package com.nhnacademy.edu.gateway.controller;

import com.nhnacademy.edu.gateway.adaptor.AccountAdaptor;
import com.nhnacademy.edu.gateway.adaptor.ProjectMemberAdaptor;
import com.nhnacademy.edu.gateway.domain.Account;
import com.nhnacademy.edu.gateway.domain.ProjectMember;
import com.nhnacademy.edu.gateway.request.LoginRequest;
import com.nhnacademy.edu.gateway.request.MemberRequest;
import com.nhnacademy.edu.gateway.request.ProjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {
    private final AccountAdaptor accountAdaptor;
    private final ProjectMemberAdaptor projectMemberAdaptor;
    @GetMapping("/task")
    public String taskMain(Model model) {
        List<Account> accountList = accountAdaptor.getAccounts();

        model.addAttribute("accountList", accountList);

        return "taskPage";
    }

    @GetMapping("/taskDetail")
    public String taskDetailTest() {
        return "taskDetailPage";
    }



//    @PostMapping(value = "/task/memberGet")
//    public String getMember(Model model, ProjectRequest projectRequest, HttpSession session){
//        List<Account> accountList = accountAdaptor.getAccounts();
//
//        model.addAttribute("accountList", accountList);
//
//        return "taskPage";
//    }

//    @PostMapping(value = "/task/memberAdd")
//    public String addMember(Model model, MemberRequest memberRequest, HttpSession session){
//
//        ProjectMember projectMember = new ProjectMember(memberRequest.getProjectNumber(),memberRequest.getUserName());
//        projectMemberAdaptor.createProjectMember(projectMember);
//
//        return "redirect:/taskPage";
//    }
}
