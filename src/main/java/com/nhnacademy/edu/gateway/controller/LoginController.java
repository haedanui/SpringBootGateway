package com.nhnacademy.edu.gateway.controller;

import com.nhnacademy.edu.gateway.adaptor.AccountAdaptor;
import com.nhnacademy.edu.gateway.adaptor.ProjectAdaptor;
import com.nhnacademy.edu.gateway.adaptor.ProjectMemberAdaptor;
import com.nhnacademy.edu.gateway.domain.Account;
import com.nhnacademy.edu.gateway.domain.Project;
import com.nhnacademy.edu.gateway.domain.ProjectMember;
import com.nhnacademy.edu.gateway.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;


@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final AccountAdaptor accountAdaptor;
    private final ProjectMemberAdaptor projectMemberAdaptor;
    private final ProjectAdaptor projectAdaptor;

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    @PostMapping(value = "/login")
    public String doLogin(Model model, LoginRequest loginRequest, HttpSession session){
        Account account = accountAdaptor.getAccount(loginRequest.getUserId());
        if(account.getUserId().equals(loginRequest.getUserId()) &&
            account.getUserPassword().equals(loginRequest.getUserPassword())){
            session.setAttribute("loginUserInfo", loginRequest);

            model.addAttribute("message", "로그인 성공!");
            model.addAttribute("searchUrl", "/mainPage");

            return "alert";

        } else{
//            model.addAttribute("loginFail","로그인 실패");
//            return "loginForm";
            model.addAttribute("message", "로그인 실패! 아이디와 비밀번호를 확인하세요.");
            model.addAttribute("searchUrl", "/login");

            return "alert";
        }
    }



    @PostMapping(value = "/login/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(false);
        if(Objects.nonNull(session)){
            session.invalidate();
            Cookie cookie = new Cookie("JSESSIONID","");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        return "redirect:/login";
    }
}
