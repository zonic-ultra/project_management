package com.dendev.project_management.dto.project;

import com.dendev.project_management.entity.Project;
import com.dendev.project_management.entity.Task;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ProjectResponseDto {
    private Long project_id;
    private String project_name;
    private String project_description;
    private List<Task> tasks;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProjectResponseDto(Project project) {
        this.project_id = project.getProject_id();
        this.project_name = project.getProject_name();
        this.project_description = project.getProject_description();
        this.tasks = project.getTasks();
        this.createdAt = project.getCreatedAt();
        this.updatedAt = project.getUpdatedAt();
    }
}
