package com.dendev.project_management.service.impl;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.change_log.ChangeLogDto;
import com.dendev.project_management.dto.change_log.ChangeLogResponseDto;
import com.dendev.project_management.dto.task.TaskRequestDto;
import com.dendev.project_management.dto.task.TaskResponseDto;
import com.dendev.project_management.entity.ChangeLog;
import com.dendev.project_management.entity.Project;
import com.dendev.project_management.entity.Task;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.enums.Role;
import com.dendev.project_management.enums.TaskStatus;
import com.dendev.project_management.exceptions.ResourceNotFoundException;
import com.dendev.project_management.repository.ProjectRepository;
import com.dendev.project_management.repository.TaskRepository;
import com.dendev.project_management.repository.UserRepository;
import com.dendev.project_management.service.ChangeLogService;
import com.dendev.project_management.service.TaskService;
import com.dendev.project_management.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final ChangeLogService changeLogService;

    @Override
    @Transactional
    public Response<TaskResponseDto> createTask(TaskRequestDto dto) {

        User assignedUser = userRepository.findById(dto.getUser_id())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));


        Project project = projectRepository.findById(dto.getProject_id())
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));


        Task task = Task.builder()
                .task_name(dto.getTask_name())
                .contents(dto.getContents())
                .taskStatus(dto.getTaskStatus() != null ? dto.getTaskStatus() : TaskStatus.TODO)
                .dueDate(dto.getDueDate())
                .project(project)
                .assignedUser(assignedUser)
                .build();

        Task savedTask = taskRepository.save(task);

        changeLogService.logStatusChange(savedTask.getId(), dto.getTaskStatus(), "Task created successfully");

        return Response.<TaskResponseDto>builder()
                .status(200)
                .message("Task created successfully")
                .data(new TaskResponseDto(savedTask))
                .build();
    }

    @Override
    @Transactional
    public Response<TaskResponseDto> updateTask(Long id, TaskRequestDto dto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        if (dto.getProject_id() != null) {
            Project project = projectRepository.findById(dto.getProject_id())
                    .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
            task.setProject(project);
        }

        if (dto.getUser_id() != null) {
            User user = userRepository.findById(dto.getUser_id())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));
            task.setAssignedUser(user);
        }

        if (dto.getTask_name() != null) task.setTask_name(dto.getTask_name());
        if (dto.getContents() != null) task.setContents(dto.getContents());
        if (dto.getTaskStatus() != null) task.setTaskStatus(dto.getTaskStatus());
        if (dto.getDueDate() != null) task.setDueDate(dto.getDueDate());

        Task updatedTask = taskRepository.save(task);

        changeLogService.logStatusChange(updatedTask.getId(), updatedTask.getTaskStatus(), "Task updated successfully");


        return Response.<TaskResponseDto>builder()
                .status(200)
                .message("Task updated successfully")
                .data(new TaskResponseDto(updatedTask))
                .build();
    }

    @Override
    @Transactional
    public Response<Void> deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        taskRepository.delete(task);

        return Response.<Void>builder()
                .status(200)
                .message("Task deleted successfully")
                .build();
    }

    @Override
    public Response<TaskResponseDto> findTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        return Response.<TaskResponseDto>builder()
                .status(200)
                .message("Task found")
                .data(new TaskResponseDto(task))
                .build();
    }

    @Override
    public Response<List<TaskResponseDto>> findAllTasks() {
        User currentUser = userService.getCurrentUser();
        List<Task> taskList;

        if (currentUser.getRole() == Role.ADMIN) {
            taskList = taskRepository.findAll();
        } else {
            taskList = taskRepository.findByAssignedUser(currentUser);
        }

        List<TaskResponseDto> dtoList = taskList.stream()
                .map(TaskResponseDto::new)
                .toList();

        return Response.<List<TaskResponseDto>>builder()
                .status(200)
                .message("Tasks retrieved successfully")
                .data(dtoList)
                .build();
    }

    @Override
    @Transactional
    public Response<ChangeLogResponseDto> updateTaskStatus(Long id, ChangeLogDto changeLogDto) {

//        Task task = taskRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
//
//        task.getTaskStatus()
//        TaskStatus newStatus = changeLogDto.getNewStatus();
//
//        task.setTaskStatus(newStatus);
//
//        Task updatedTask = taskRepository.save(task);

//        // 1. Find the task
//        Task task = taskRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
//
//        // 2. Store old status before updating
//        TaskStatus oldStatus = task.getTaskStatus();
//
//        // 3. Get new status from DTO
//        TaskStatus newStatus = changeLogDto.getNewStatus();
//
//        if (newStatus == null) {
//            throw new IllegalArgumentException("New status is required");
//        }
//
//        // 4. Update task status
//        task.setTaskStatus(newStatus);
//        Task updatedTask = taskRepository.save(task);
//
//        // 6. Log the status change
//        changeLogService.logStatusChange(
//                updatedTask.getId(),
//                newStatus,
//                changeLogDto.getRemarks()
//        );
//
//
//
//        ChangeLogResponseDto responseDto = new ChangeLogResponseDto();
//        responseDto.setId(updatedTask.getId());
//        responseDto.setNewStatus(updatedTask.getTaskStatus());
//
//        return Response.<ChangeLogResponseDto>builder()
//                .status(200)
//                .message("Task status updated successfully")
//                .data(responseDto)
//                .build();

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        TaskStatus newStatus = changeLogDto.getNewStatus();

        if (newStatus == null) {
            throw new IllegalArgumentException("New status is required");
        }

        // Update task status
        task.setTaskStatus(newStatus);
        Task updatedTask = taskRepository.save(task);

        // Get current user
        User currentUser = userService.getCurrentUser();

        // Log the change
        changeLogService.logStatusChange(updatedTask.getId(), newStatus, changeLogDto.getRemarks());

        // Create simple response
        ChangeLogResponseDto responseDto = new ChangeLogResponseDto();
        responseDto.setTaskId(updatedTask.getId());
        responseDto.setUsername(currentUser.getUsername());
        responseDto.setNewStatus(newStatus);
        responseDto.setRemarks(changeLogDto.getRemarks());
        responseDto.setChangedAt(LocalDateTime.now());

        return Response.<ChangeLogResponseDto>builder()
                .status(200)
                .message("Task status updated successfully")
                .data(responseDto)
                .build();
    }
}


