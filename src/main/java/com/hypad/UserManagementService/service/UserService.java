package com.hypad.UserManagementService.service;

import com.hypad.UserManagementService.dto.UserDTO;
import com.hypad.UserManagementService.enums.RoleEnum;
import com.hypad.UserManagementService.model.UserModel;
import com.hypad.UserManagementService.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String save(UserDTO userDTO){

        UserModel user = UserModel
                .builder()
                .email(userDTO.getEmail())
                .role(RoleEnum.USER_ROLE)
                .username(userDTO.getUsername())
                .password(new BCryptPasswordEncoder().encode(userDTO.getPassword()))
                .build();

        repository.save(user);

        return user + " signed up";
    }
}
