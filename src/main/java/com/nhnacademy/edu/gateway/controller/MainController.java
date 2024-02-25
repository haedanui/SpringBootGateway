package com.nhnacademy.edu.gateway.controller;

import com.nhnacademy.edu.gateway.adaptor.AccountAdaptor;
import com.nhnacademy.edu.gateway.adaptor.ProjectAdaptor;
import com.nhnacademy.edu.gateway.adaptor.ProjectMemberAdaptor;
import com.nhnacademy.edu.gateway.adaptor.TaskAdaptor;
import com.nhnacademy.edu.gateway.domain.*;
import com.nhnacademy.edu.gateway.request.LoginRequest;
import com.nhnacademy.edu.gateway.request.MemberRequest;
import com.nhnacademy.edu.gateway.request.ProjectRequest;
import com.nhnacademy.edu.gateway.request.TaskRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController {
    private final AccountAdaptor accountAdaptor;

    private final ProjectAdaptor projectAdaptor;

    private final ProjectMemberAdaptor projectMemberAdaptor;

    private final TaskAdaptor taskAdaptor;

    @GetMapping("/mainPage")
    public String getMainPage(Model model, HttpSession session) {
        LoginRequest loginRequest = (LoginRequest) session.getAttribute("loginUserInfo");
        Account account = accountAdaptor.getAccount(loginRequest.getUserId());
        model.addAttribute("accountInfo", account);
        //        List<Project> projectList = (List<Project>) model.getAttribute("projectList");

        List<Project> projectList = projectAdaptor.getProjects(account.getUserName());
        model.addAttribute("projectList",projectList);

        return "mainPage";
    }
    @PostMapping(value = "/mainPage/projectAdd")
    public String createProject(Model model, ProjectRequest projectRequest, HttpSession session){
        LoginRequest loginRequest = (LoginRequest) session.getAttribute("loginUserInfo");
        Account account = accountAdaptor.getAccount(loginRequest.getUserId());

        ProjectCreate projectCreate = new ProjectCreate(projectRequest.getProjectName(),account.getUserName());
        projectAdaptor.createProject(projectCreate);

        return "redirect:/mainPage";
    }

    @PostMapping(value = "/mainPage/projectGet")
    public String getProject(Model model, ProjectRequest projectRequest, HttpSession session){
        LoginRequest loginRequest = (LoginRequest) session.getAttribute("loginUserInfo");
        Account account = accountAdaptor.getAccount(loginRequest.getUserId());
        List<Project> projectList = projectAdaptor.getProjects(account.getUserName());
        List<ProjectMember> projectMemberList = projectMemberAdaptor.getProjectMembers(projectRequest.getProjectNumber());
        List<Task> taskList = taskAdaptor.getTasks(projectRequest.getProjectNumber());

        model.addAttribute("projectList",projectList);
        model.addAttribute("accountInfo", account);
        model.addAttribute("projectRequest",projectRequest);
        model.addAttribute("projectMemberList",projectMemberList);
        model.addAttribute("taskList",taskList);

        return "mainPage";
    }

    @PostMapping(value = "/mainPage/deleteProject")
    public String deleteProject(ProjectRequest projectRequest){

        projectAdaptor.deleteProject(projectRequest.getProjectNumber());

        return "redirect:/mainPage";
    }

    @PostMapping(value = "/mainPage/memberAdd")
    public String addMember(Model model, MemberRequest memberRequest, HttpSession session){
        LoginRequest loginRequest = (LoginRequest) session.getAttribute("loginUserInfo");

        ProjectMember projectMember = new ProjectMember(memberRequest.getProjectNumber(),memberRequest.getUserName());
        projectMemberAdaptor.createProjectMember(projectMember);

        return "redirect:/mainPage";
    }

    @PostMapping(value = "/mainPage/createTask")
    public String createTask(Model model, TaskRequest taskRequest,ProjectRequest projectRequest, HttpSession session){
        LoginRequest loginRequest = (LoginRequest) session.getAttribute("loginUserInfo");
        Account account = accountAdaptor.getAccount(loginRequest.getUserId());
        Task task = new Task(taskRequest.getTaskTitle(),taskRequest.getTaskContent(),taskRequest.getTaskState());
        taskAdaptor.createTask(projectRequest.getProjectNumber(),task);
        return "redirect:/mainPage";
    }

    @PostMapping(value = "/mainPage/deletetask")
    public String deleteTask(Model model, ProjectRequest projectRequest, HttpSession session){

//        taskAdaptor.deleteTask(projectRequest.getProjectNumber(), );

        return "redirect:/mainPage";
    }
}
