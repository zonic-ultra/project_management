package com.dendev.project_management.dto.task;

import com.dendev.project_management.enums.TaskStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskRequestDto {

    @NotBlank(message = "Task name is required!")
    @Size(min = 2, max = 100, message = "Description must be between 2 and 100 characters")
    private String task_name;

    @Size(min = 2, max = 500, message = "Description must be between 2 and 500 characters")
    private String description;

    private TaskStatus taskStatus;

    @FutureOrPresent(message = "Due date must be today or in future")
    private LocalDate dueDate;

    @NotNull
    private Long user_id;

    @NotNull
    private Long project_id;
}
