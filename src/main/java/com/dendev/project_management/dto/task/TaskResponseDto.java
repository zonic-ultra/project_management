package com.dendev.project_management.dto.task;

import com.dendev.project_management.entity.Project;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskResponseDto {
    private Long id;
    private String task_name;
    private String description;
    private Project project;
    private User user;
    private TaskStatus taskStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
