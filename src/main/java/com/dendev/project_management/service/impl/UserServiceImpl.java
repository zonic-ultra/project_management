package com.dendev.project_management.service.impl;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.auth.LoginRequest;
import com.dendev.project_management.dto.auth.RegisterRequest;
import com.dendev.project_management.dto.user.UserDto;
import com.dendev.project_management.dto.user.UserResponseDto;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.enums.Role;
import com.dendev.project_management.exceptions.BadRequestException;
import com.dendev.project_management.exceptions.ResourceNotFoundException;
import com.dendev.project_management.repository.UserRepository;
import com.dendev.project_management.security.JwtUtils;
import com.dendev.project_management.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private JwtUtils jwtUtils;
//
//    @Override
//    public Response<?> signUp(RegisterRequest registerRequest) {
//        Optional<User> existingUser = userRepository.findByUsername(registerRequest.getUsername());
//
//        if (existingUser.isPresent()){
//            throw new BadRequestException("Username already exists");
//        }
//
//        Role role = Role.USER;
//
//        if (registerRequest.getRole() != null) {
//            role = registerRequest.getRole();
//        }
//
//        User userToSave = User.builder()
//                .name(registerRequest.getUsername())
//                .username(registerRequest.getUsername())
//                .password(passwordEncoder.encode(registerRequest.getPassword()))
//                .role(role)
//                .createdAt(registerRequest.getCreatedAt())
//                .build();
//        userRepository.save(userToSave);
//
//        return Response.builder()
//                .status(200)
////                .data(userToSave)
//                .message("User was successfully registered...")
//                .build();
//    }
//
//    @Override
//    public Response<?> login(LoginRequest loginRequest) {
//        User user = userRepository.findByUsername(loginRequest.getUsername())
//                .orElseThrow(()-> new BadRequestException("Username not found"));
//
//        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
//            throw new BadRequestException("Invalid password");
//        }
//
//        String token = jwtUtils.generateToken(user.getUsername());
//
//        return Response.builder()
//                .status(200)
//                .message("User login successfully")
//                .data(token)
//                .build();
//
//    }

    @Override
    public Response<?> getAllUsers() {
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.ASC, "username"));

        List<UserResponseDto> userResponse = users.stream()
                .map(UserResponseDto::new)
                .toList();

        return Response.builder()
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

//    private User getCurrentUserEntity(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        String username = authentication.getName();
//        Optional<User> user = Optional.of(userRepository.findByUsername(username)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found!")));
//
//        return user.get();
//    }

    @Override
    public Response<?> updateUser(Long id, UserDto userDto) {
        User existingUserToUpdate = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found!"));

        if (existingUserToUpdate.getUsername()!= null) {
            existingUserToUpdate.setUsername(userDto.getUsername());
        }

        if (userDto.getPassword() != null && userDto.getPassword().isEmpty()){
            existingUserToUpdate.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }

        if (userDto.getName() != null) {
            existingUserToUpdate.setName(userDto.getName());
        }

        if (userDto.getRole() != null){
            existingUserToUpdate.setRole(userDto.getRole());
        }

        userRepository.save(existingUserToUpdate);

        return Response.builder()
                .status(200)
                .message("User updated successfully")
                .data(existingUserToUpdate)
                .build();
    }

    @Override
    public Response<?> deleteUser(Long id) {
        userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found!"));

        userRepository.deleteById(id);

        return Response.builder()
                .status(200)
                .message("User deleted successfully")
                .build();
    }


}
