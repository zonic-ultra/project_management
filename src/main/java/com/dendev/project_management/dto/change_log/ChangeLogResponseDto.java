package com.dendev.project_management.dto.change_log;

import com.dendev.project_management.entity.ChangeLog;
import com.dendev.project_management.entity.Task;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.enums.TaskStatus;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class ChangeLogResponseDto {
    private Long  id;
    private Long taskId;
    private String taskName;
    private String changeBy;        // who changed the status
    private TaskStatus newStatus;
    private String remarks;
    private LocalDateTime createdAt;

    // Constructor to map from Entity
    public ChangeLogResponseDto(ChangeLog changeLog) {
        this.id = changeLog.getId();
        this.changeBy = changeLog.getChangedBy().getName();
        this.newStatus = changeLog.getNew_status();
        this.remarks = changeLog.getRemarks();
        this.createdAt = changeLog.getCreatedAt();

        if (changeLog.getTask() != null) {
            this.taskId = changeLog.getTask().getId();
            this.taskName = changeLog.getTask().getTask_name();
        }
    }
}
