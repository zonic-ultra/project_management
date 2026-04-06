package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.change_log.ChangeLogResponseDto;
import com.dendev.project_management.entity.ChangeLog;
import com.dendev.project_management.entity.Task;
import com.dendev.project_management.enums.TaskStatus;

import java.util.List;

public interface ChangeLogService {
    Response<Void> logChange(Task task, String username,ChangeLog changeLog);

    Response<ChangeLog> findById(Long id);

    Response<Void> logStatusChange(Task task,String username, TaskStatus oldStatus, TaskStatus newStatus,String remark);

    Response<List<ChangeLogResponseDto>> getTaskHistory();

}
