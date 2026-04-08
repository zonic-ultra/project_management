package com.dendev.project_management.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ChangePasswordRequest {

    @NotBlank(message = "Current password required!")
    private String currentPassword;

    @NotBlank(message = "New password required!")
    private String newPassword;

    @NotBlank
    private String confirmNewPassword;
}
