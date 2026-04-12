package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.change_log.ChangeLogDto;
import com.dendev.project_management.dto.change_log.ChangeLogResponseDto;
import com.dendev.project_management.dto.task.TaskRequestDto;
import com.dendev.project_management.dto.task.TaskResponseDto;
import com.dendev.project_management.enums.TaskStatus;

import java.util.List;

public interface TaskService {
    Response<TaskResponseDto> createTask(TaskRequestDto dto);
    Response<TaskResponseDto> updateTask(Long id, TaskRequestDto dto);
    Response<Void> deleteTask(Long id);
    Response<TaskResponseDto> findTask(Long id);
    Response<List<TaskResponseDto>> findAllTasks();
    Response<ChangeLogResponseDto> updateTaskStatus(Long id, ChangeLogDto changeLogDto);
    long getTotalTasks();
}
