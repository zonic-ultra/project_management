package com.dendev.project_management.service.impl;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.auth.LoginRequest;
import com.dendev.project_management.dto.auth.RegisterRequest;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.enums.Role;
import com.dendev.project_management.exceptions.BadRequestException;
import com.dendev.project_management.repository.UserRepository;
import com.dendev.project_management.security.JwtUtils;
import com.dendev.project_management.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public Response<?> signUp(RegisterRequest registerRequest) {
        Optional<User> existingUser = userRepository.findByUsername(registerRequest.getUsername());

        if (existingUser.isPresent()){
            throw new BadRequestException("Username already exists");
        }

        Role role = Role.USER;

        if (registerRequest.getRole() != null) {
            role = registerRequest.getRole();
        }

        User userToSave = User.builder()
                .name(registerRequest.getName())
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(role)
                .createdAt(registerRequest.getCreatedAt())
                .build();
        userRepository.save(userToSave);

        return Response.builder()
                .status(200)
//                .data(userToSave)
                .message("User was successfully registered...")
                .build();
    }

    @Override
    public Response<?> login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(()-> new BadRequestException("Username not found"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new BadRequestException("Invalid password");
        }

        String token = jwtUtils.generateToken(user.getUsername());

        return Response.builder()
                .status(200)
                .message("User login successfully")
                .data(token)
                .build();

    }
}
