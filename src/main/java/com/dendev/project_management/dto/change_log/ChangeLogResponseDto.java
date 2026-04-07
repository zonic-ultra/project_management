package com.dendev.project_management.dto.change_log;

import com.dendev.project_management.entity.ChangeLog;
import com.dendev.project_management.entity.Task;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.enums.TaskStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class ChangeLogResponseDto {
    private Long id;
    private Long taskId;
    private String taskName;
    private String projectName;
    private String username;
    private LocalDateTime changedAt;
    private String action;
    private TaskStatus newStatus;
    private String remarks;
    private TaskStatus currentTaskStatus;

    public ChangeLogResponseDto(ChangeLog changeLog) {
        this.id = changeLog.getId();
        this.taskId = changeLog.getTask() != null ? changeLog.getTask().getId() : null;
        this.taskName = changeLog.getTask() != null ? changeLog.getTask().getTask_name() : null; // adjust if field name differs
        this.projectName = (changeLog.getTask() != null && changeLog.getTask().getProject() != null)
                ? changeLog.getTask().getProject().getProject_name() : null;
        this.username = changeLog.getChangedBy() != null ? changeLog.getChangedBy().getUsername() : null;
        this.changedAt = changeLog.getChangedAt();
        this.action = changeLog.getAction();
        this.newStatus = changeLog.getNew_status();
        this.remarks = changeLog.getRemarks();
        this.currentTaskStatus = changeLog.getTask() != null ? changeLog.getTask().getTaskStatus() : null;
    }
}
