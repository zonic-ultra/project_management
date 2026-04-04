package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.auth.LoginRequest;
import com.dendev.project_management.dto.auth.RegisterRequest;

public interface AuthService {
    Response<?> signUp(RegisterRequest registerRequest);
    Response<?> login(LoginRequest loginRequest);
}
