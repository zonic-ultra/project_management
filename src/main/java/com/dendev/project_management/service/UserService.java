package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.auth.LoginRequest;
import com.dendev.project_management.dto.auth.RegisterRequest;
import com.dendev.project_management.dto.user.UserDto;
import com.dendev.project_management.entity.User;

public interface UserService {
//    Response<?>  signUp(RegisterRequest registerRequest);
//    Response<?> login(LoginRequest loginRequest);
    Response<?>  getAllUsers();
    User getCurrentUser();
    Response<?> updateUser(Long id, UserDto userDto);
    Response<?> deleteUser(Long id);
}
