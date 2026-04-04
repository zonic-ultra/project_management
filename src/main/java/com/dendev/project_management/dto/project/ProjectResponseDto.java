package com.dendev.project_management.dto.project;

import com.dendev.project_management.entity.Task;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProjectResponseDto {
    private Long project_id;
    private String project_name;
    private String project_description;
    private List<Task> tasks;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
