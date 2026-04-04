package com.dendev.project_management.dto.project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProjectDto {
    @NotBlank(message = "Project name is required!")
    @Size(min = 2, max = 100, message = "Description must be between 2 and 100 characters")
    private String project_name;

    @Size(min = 2, max = 500, message = "Description must be between 2 and 500 characters")
    private String project_description;
}
