package com.dendev.project_management.service.impl;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.task.TaskRequestDto;
import com.dendev.project_management.dto.task.TaskResponseDto;
import com.dendev.project_management.entity.Project;
import com.dendev.project_management.entity.Task;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.enums.Role;
import com.dendev.project_management.exceptions.ResourceNotFoundException;
import com.dendev.project_management.repository.ProjectRepository;
import com.dendev.project_management.repository.TaskRepository;
import com.dendev.project_management.repository.UserRepository;
import com.dendev.project_management.service.TaskService;
import com.dendev.project_management.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Override
    public Response<TaskResponseDto> createTask(TaskRequestDto taskRequestDto) {
        User user = userRepository.findById(taskRequestDto.getUser_id())
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));

        Project project = projectRepository.findById(taskRequestDto.getProject_id())
                .orElseThrow(()-> new ResourceNotFoundException("Project not found"));

        Task task = Task.builder()
                .task_name(taskRequestDto.getTask_name())
                .contents(taskRequestDto.getDescription())
                .taskStatus(taskRequestDto.getTaskStatus())
                .dueDate(taskRequestDto.getDueDate())
                .project(project)
                .assignedUser(user)
                .build();

        Task taskToSave =  taskRepository.save(task);

        TaskResponseDto responseDto = new TaskResponseDto(taskToSave);

        return Response.<TaskResponseDto>builder()
                .status(200)
                .message("Task created")
                .data(responseDto)
                .build();
    }

    @Override
    public Response<TaskResponseDto> updateTask(TaskRequestDto taskRequestDto) {
        return null;
    }

    @Override
    public Response<Void> deleteTask(Long id) {
        return null;
    }

    @Override
    public Response<TaskResponseDto> findTask(Long id) {
        return null;
    }

    @Override
    public Response<List<TaskResponseDto>> findAllTasks() {

        User currentUser = userService.getCurrentUser();

        List<Task> taskList;

        if (currentUser.getRole() == Role.ADMIN) {
            taskList = taskRepository.findAll();
        }else{
            taskList = taskRepository.findByAssignedUser(currentUser);
        }

        List<TaskResponseDto> list =taskList.stream()
                .map(TaskResponseDto::new)
                .toList();

        return Response.<List<TaskResponseDto>>builder()
                .status(200)
                .message("Tasks found")
                .data(list)
                .build();
    }
}
