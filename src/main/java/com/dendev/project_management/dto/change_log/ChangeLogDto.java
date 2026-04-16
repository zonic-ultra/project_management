package com.dendev.project_management.dto.change_log;

import com.dendev.project_management.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChangeLogDto {
    private Long taskId;
    private TaskStatus newStatus;
    private String remarks;
}
