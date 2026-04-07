package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.change_log.ChangeLogDto;
import com.dendev.project_management.dto.change_log.ChangeLogResponseDto;
import com.dendev.project_management.entity.ChangeLog;
import com.dendev.project_management.entity.Task;
import com.dendev.project_management.enums.TaskStatus;

import java.util.List;

public interface ChangeLogService {
    Response<ChangeLogResponseDto> createChangeLog(ChangeLogDto dto);

    void logStatusChange(Long taskId, TaskStatus newStatus, String remarks);

    Response<List<ChangeLogResponseDto>> getTaskHistory(Long taskId);

    Response<List<ChangeLogResponseDto>> getChangeLogs();

    Response<Void> deleteLog(Long id);
}