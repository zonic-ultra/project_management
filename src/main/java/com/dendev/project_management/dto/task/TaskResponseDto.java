package com.dendev.project_management.dto.task;

import com.dendev.project_management.entity.Task;
import com.dendev.project_management.enums.TaskStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TaskResponseDto {
    private Long id;
    private String task_name;
    private String contents;
    private TaskStatus taskStatus;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Long project_id;
    private String project_name;

    private Long user_id;
    private String username;

    public TaskResponseDto(Task task) {
        this.id = task.getId();
        this.task_name = task.getTask_name();
        this.contents = task.getContents();
        this.taskStatus = task.getTaskStatus();
        this.dueDate = task.getDueDate();
        this.createdAt = task.getCreatedAt();
        this.updatedAt = task.getUpdatedAt();

        if (task.getProject() != null) {
            this.project_id = task.getProject().getProject_id();
            this.project_name = task.getProject().getProject_name();
        }

        if (task.getAssignedUser() != null) {
            this.user_id = task.getAssignedUser().getId();
            this.username = task.getAssignedUser().getName();
        }
    }
}
