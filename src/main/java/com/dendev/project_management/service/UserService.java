package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.auth.LoginRequest;
import com.dendev.project_management.dto.auth.RegisterRequest;
import com.dendev.project_management.dto.user.UserDto;
import com.dendev.project_management.dto.user.UserResponseDto;
import com.dendev.project_management.entity.User;

import java.util.List;

public interface UserService {
//    Response<?>  signUp(RegisterRequest registerRequest);
//    Response<?> login(LoginRequest loginRequest);
    Response<List<UserResponseDto>>  getAllMembers();
    User getCurrentUser();
    Response<?> updateMember(Long id, UserDto userDto);
    Response<Void> deleteMember(Long id);
    Response<UserResponseDto> getMember(Long id);
}
