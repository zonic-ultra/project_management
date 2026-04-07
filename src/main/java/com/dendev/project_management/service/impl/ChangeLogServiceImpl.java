package com.dendev.project_management.service.impl;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.change_log.ChangeLogDto;
import com.dendev.project_management.dto.change_log.ChangeLogResponseDto;
import com.dendev.project_management.entity.ChangeLog;
import com.dendev.project_management.entity.Task;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.enums.TaskStatus;
import com.dendev.project_management.exceptions.ResourceNotFoundException;
import com.dendev.project_management.repository.ChangeLogRepository;
import com.dendev.project_management.repository.TaskRepository;
import com.dendev.project_management.service.ChangeLogService;
import com.dendev.project_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChangeLogServiceImpl implements ChangeLogService {

    private final ChangeLogRepository changeLogRepository;
    private final UserService userService;
    private final TaskRepository taskRepository;

    @Override
    @Transactional
    public Response<ChangeLogResponseDto> createChangeLog(ChangeLogDto dto) {
        Task task = taskRepository.findById(dto.getTaskId())
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        User changedBy = userService.getCurrentUser();

        ChangeLog log = ChangeLog.builder()
                .task(task)
                .changedBy(changedBy)
                .action("STATUS_CHANGED")
                .new_status(dto.getNewStatus())
                .remarks(dto.getRemarks())
                .build();

        ChangeLog savedLog = changeLogRepository.save(log);

        return Response.<ChangeLogResponseDto>builder()
                .status(200)
                .message("Change log created successfully")
                .data(new ChangeLogResponseDto(savedLog))
                .build();
    }

    @Override
    public void logStatusChange(Long taskId, TaskStatus newStatus, String remarks) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        User changedBy = userService.getCurrentUser();

        ChangeLog log = ChangeLog.builder()
                .task(task)
                .changedBy(changedBy)
                .action("STATUS_CHANGED")
                .new_status(newStatus)
                .remarks(remarks)
                .build();

        changeLogRepository.save(log);
    }

    @Override
    public Response<List<ChangeLogResponseDto>> getTaskHistory(Long taskId) {
        List<ChangeLog> logs = changeLogRepository.findByTaskIdOrderByChangedAtDesc(taskId);

        List<ChangeLogResponseDto> list = logs.stream()
                .map(ChangeLogResponseDto::new)
                .toList();

        return Response.<List<ChangeLogResponseDto>>builder()
                .status(200)
                .message("Task history retrieved successfully")
                .data(list)
                .build();
    }

    @Override
    public Response<List<ChangeLogResponseDto>> getChangeLogs() {
        List<ChangeLog> logs = changeLogRepository.findAllByOrderByChangedAtDesc();

        List<ChangeLogResponseDto> dtoList = logs.stream()
                .map(ChangeLogResponseDto::new)
                .toList();

        return Response.<List<ChangeLogResponseDto>>builder()
                .status(200)
                .message("All change logs retrieved successfully")
                .data(dtoList)
                .build();
    }

}