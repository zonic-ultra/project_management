package com.dendev.project_management.controller;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.user.UserResponseDto;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/current")
    public ResponseEntity<User> getCurrentUser() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }

    @GetMapping("/get_all_member")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<List<UserResponseDto>>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllMembers());
    }

    @GetMapping("/get_member")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<UserResponseDto>> getMember(@RequestParam("id") Long id){
        return ResponseEntity.ok(userService.getMember(id));
    }

    @DeleteMapping("/delete_member")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<Void>> deleteUser(@RequestParam("id") Long id){
        return ResponseEntity.ok(userService.deleteMember(id));
    }


}
