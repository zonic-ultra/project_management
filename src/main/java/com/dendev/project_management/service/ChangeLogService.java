package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.change_log.ChangeLogDto;
import com.dendev.project_management.dto.change_log.ChangeLogResponseDto;
import com.dendev.project_management.entity.Task;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.enums.TaskStatus;

import java.util.List;

public interface ChangeLogService {
    void logStatusChange(Task task, TaskStatus newStatus, String remarks, User changedBy);

    Response<List<ChangeLogResponseDto>> getChangeLogs();

    Response<Void> deleteLog(Long id);
}