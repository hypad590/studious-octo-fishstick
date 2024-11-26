package com.hypad.UserManagementService.service;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SignService {
    public String checkAuthentication(String template){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken){
            return template;
        }

        return "redirect:/";
    }
}
