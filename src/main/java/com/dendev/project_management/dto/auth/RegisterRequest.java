package com.dendev.project_management.dto.auth;

import com.dendev.project_management.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterRequest {
    @Email
    @NotBlank(message = "Username is required!")
    private String username;

    @NotBlank(message = "Password is required!")
    private String password;

    @NotBlank(message = "Name is required!")
    private String name;

    private Role role;
}
