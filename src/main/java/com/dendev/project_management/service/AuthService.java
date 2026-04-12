package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.auth.LoginRequest;
import com.dendev.project_management.dto.auth.RegisterRequest;
import com.dendev.project_management.dto.user.UserResponseDto;
import com.dendev.project_management.entity.User;

public interface AuthService {
    Response<User> signUp(RegisterRequest registerRequest);
    Response<?> login(LoginRequest loginRequest);
}
