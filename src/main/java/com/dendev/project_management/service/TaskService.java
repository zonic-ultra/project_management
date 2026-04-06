package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.task.TaskRequestDto;
import com.dendev.project_management.dto.task.TaskResponseDto;

import java.util.List;

public interface TaskService {
    Response<TaskResponseDto> createTask(TaskRequestDto taskRequestDto);
    Response<TaskResponseDto> updateTask(Long id, TaskRequestDto taskRequestDto);
    Response<Void> deleteTask(Long id);
    Response<TaskResponseDto> findTask(Long id);
    Response<List<TaskResponseDto>> findAllTasks();

    Response<TaskResponseDto> updateTaskStatus(Long id, String username, TaskRequestDto taskRequestDto, String remark);
}
