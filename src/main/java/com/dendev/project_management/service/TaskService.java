package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.task.TaskRequestDto;

public interface TaskService {
    Response<?> createTask(TaskRequestDto taskRequestDto);
    Response<?> updateTask(TaskRequestDto taskRequestDto);
    Response<?> deleteTask(Long id);
    Response<?> findTask(Long id);
    Response<?> findAllTasks();
}
