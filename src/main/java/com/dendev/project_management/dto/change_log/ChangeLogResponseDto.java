package com.dendev.project_management.dto.change_log;

import com.dendev.project_management.entity.ChangeLog;
import com.dendev.project_management.entity.Task;
import com.dendev.project_management.entity.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class ChangeLogResponseDto {
    private Long id;
    private Task task;
    private User changedBy;
    private LocalDateTime changedAt;
    private String old_status;
    private String new_status;
    private String remarks;

    public ChangeLogResponseDto(ChangeLog changeLog) {
        this.id = changeLog.getId();
        this.task = changeLog.getTask();
        this.changedBy = changeLog.getChangedBy();
        this.changedAt = changeLog.getChangedAt();
        this.old_status = changeLog.getOld_status();
        this.new_status = changeLog.getNew_status();
        this.remarks = changeLog.getRemarks();
    }
}
