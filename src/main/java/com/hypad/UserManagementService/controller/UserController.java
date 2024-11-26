package com.hypad.UserManagementService.controller;

import com.hypad.UserManagementService.dto.UserDTO;
import com.hypad.UserManagementService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                service.save(userDTO));
    }

}
