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
    private Long  id;
    private Long taskId;
    private String changeBy;        // who changed the status
    private TaskStatus newStatus;
    private String remarks;
    private LocalDateTime changedAt;

    // Constructor to map from Entity
    public ChangeLogResponseDto(ChangeLog changeLog) {
        this.id = changeLog.getId();
        this.taskId = changeLog.getTask().getId();
        this.changeBy = changeLog.getChangedBy().getName();
        this.newStatus = changeLog.getNew_status();
        this.remarks = changeLog.getRemarks();
        this.changedAt = changeLog.getChangedAt();
    }
}
