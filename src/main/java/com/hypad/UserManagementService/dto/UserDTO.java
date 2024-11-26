package com.hypad.UserManagementService.dto;

import com.hypad.UserManagementService.enums.RoleEnum;
import lombok.Getter;

@Getter
public class UserDTO {
    private Long id;

    private String username;
    private String password;
    private String email;

    private RoleEnum role;
}
