package com.dendev.project_management.service.impl;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.user.ChangePasswordRequest;
import com.dendev.project_management.dto.user.UserRequestDto;
import com.dendev.project_management.dto.user.UserResponseDto;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.exceptions.BadRequestException;
import com.dendev.project_management.exceptions.ResourceNotFoundException;
import com.dendev.project_management.repository.UserRepository;
import com.dendev.project_management.security.AuthUser;
import com.dendev.project_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Response<List<UserResponseDto>> getAllMembers() {
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.ASC, "username"));

        List<UserResponseDto> userResponse = users.stream()
                .map(UserResponseDto::new)
                .toList();

        return Response.<List<UserResponseDto>>builder()
                .status(200)
                .message("Success")
                .data(userResponse)
                .build();
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        Optional<User> user = Optional.of(userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!")));


        return user.get();
    }

    @Override
    public Response<UserResponseDto> updateMember(Long id, UserRequestDto userRequestDto) {
        User existingUser = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found!"));

        // Update fields only if they are provided (not null and not blank)
        if (userRequestDto.getUsername() != null && !userRequestDto.getUsername().isBlank()) {

            // Check if username is already taken by another user
            boolean usernameTaken = userRepository.existsByUsernameAndIdNot(userRequestDto.getUsername(), id);
            if (usernameTaken) {
                throw new BadRequestException("Username already taken");
            }
            existingUser.setUsername(userRequestDto.getUsername());
        }

        if (userRequestDto.getName() != null && !userRequestDto.getName().isBlank()) {
            existingUser.setName(userRequestDto.getName());
        }

        if (userRequestDto.getPassword() != null && !userRequestDto.getPassword().isBlank()) {
            existingUser.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        }

        userRepository.save(existingUser);

        UserResponseDto responseDto = new UserResponseDto(existingUser);

        return Response.<UserResponseDto>builder()
                .status(200)
                .message("User updated successfully")
                .data(responseDto)
                .build();
    }

    @Override
    public Response<UserResponseDto> changePassword(ChangePasswordRequest request, Principal connectedUser) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthUser authUser = (AuthUser) authentication.getPrincipal();

        //  Load the real User entity from database
        User user = userRepository.findByUsername(authUser.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        //  Check if current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new BadRequestException("Current password is not correct");
        }

        // Check if new password and confirm password match....
        if (!request.getNewPassword().equals(request.getConfirmNewPassword())) {
            throw new BadRequestException("New password and confirm password do not match");
        }

        // Update
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // Save
        userRepository.save(user);

        // Response
        UserResponseDto userResponseDto = new UserResponseDto(user);

        return Response.<UserResponseDto>builder()
                .status(200)
                .message("Your password successfully updated")
                .data(userResponseDto)
                .build();
    }

    @Override
    public long getTotalMembers() {
        return userRepository.count();
    }

    @Override
    public Response<Void> deleteMember(Long id) {
        userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found!"));

        userRepository.deleteById(id);

        return Response.<Void>builder()
                .status(200)
                .message("User deleted successfully")
                .build();
    }

    @Override
    public Response<UserResponseDto> getMember(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found!"));
        UserResponseDto userResponseDto = new UserResponseDto(user);
         return Response.<UserResponseDto>builder()
                 .status(200)
                 .message("Member found")
                 .data(userResponseDto)
                 .build();
    }




}
