package com.dendev.project_management.controller;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.user.ChangePasswordRequest;
import com.dendev.project_management.dto.user.UserRequestDto;
import com.dendev.project_management.dto.user.UserResponseDto;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/total_members")
    public ResponseEntity<Long> getTotalMember() {
        return ResponseEntity.ok(userService.getTotalMembers());
    }

    @GetMapping("/current")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<User> getCurrentUser() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }

    @GetMapping("/get_all_members")
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

    @PutMapping("/update_member")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Response<UserResponseDto>> update(@RequestParam("id") Long id, @RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok(userService.updateMember(id, userRequestDto));
    }

    @PatchMapping("/change_password")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Response<UserResponseDto>> changePassword(@RequestBody ChangePasswordRequest request, Principal connectedUser){
        return ResponseEntity.ok(userService.changePassword(request,connectedUser));
    }
}
