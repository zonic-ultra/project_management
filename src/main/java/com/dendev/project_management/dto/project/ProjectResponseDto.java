package com.dendev.project_management.dto.project;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProjectResponseDto {
    private Long id;
    private String project_name;
    private String project_description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
