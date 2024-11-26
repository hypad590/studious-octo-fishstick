package com.hypad.UserManagementService.controller;

import com.hypad.UserManagementService.service.SignService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignController {

    private final SignService signService;

    public SignController(SignService signService) {
        this.signService = signService;
    }

    @GetMapping("/signup")
    public String singUp(){
        return "signup";
    }
    @GetMapping("/signin")
    public String signIn(){
        return signService.checkAuthentication("signin");
    }
    @GetMapping("/")
    @ResponseBody
    public String homePage(){
        return "Home";
    }

    @GetMapping("/secured")
    @ResponseBody
    public String securedMapping(){
        return "Secured Mapping";
    }
}
