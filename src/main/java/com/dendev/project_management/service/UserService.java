package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.user.ChangePasswordRequest;
import com.dendev.project_management.dto.user.UserRequestDto;
import com.dendev.project_management.dto.user.UserResponseDto;
import com.dendev.project_management.entity.User;

import java.security.Principal;
import java.util.List;

public interface UserService {
    Response<List<UserResponseDto>>  getAllMembers();
    User getCurrentUser();
    Response<UserResponseDto> updateMember(Long id, UserRequestDto userRequestDto);
    Response<Void> deleteMember(Long id);
    Response<UserResponseDto> getMember(Long id);
    Response<UserResponseDto> changePassword(ChangePasswordRequest request, Principal connectedUser);
    long getTotalMembers();
}
