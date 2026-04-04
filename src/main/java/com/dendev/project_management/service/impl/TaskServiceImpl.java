package com.dendev.project_management.service.impl;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.task.TaskRequestDto;
import com.dendev.project_management.entity.Project;
import com.dendev.project_management.entity.Task;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.exceptions.ResourceNotFoundException;
import com.dendev.project_management.repository.ProjectRepository;
import com.dendev.project_management.repository.TaskRepository;
import com.dendev.project_management.repository.UserRepository;
import com.dendev.project_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Response<?> createTask(TaskRequestDto taskRequestDto) {
        User user = userRepository.findById(taskRequestDto.getUser_id())
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));

        Project project = projectRepository.findById(taskRequestDto.getProject_id())
                .orElseThrow(()-> new ResourceNotFoundException("Project not found"));

        Task task = Task.builder()
                .task_name(taskRequestDto.getTask_name())
                .description(taskRequestDto.getDescription())
                .taskStatus(taskRequestDto.getTaskStatus())
                .project(project)
                .user(user)
                .build();

        Task taskToSave =  taskRepository.save(task);

        return Response.builder()
                .status(200)
                .message("Task created")
                .data(taskToSave)
                .build();
    }

    @Override
    public Response<?> updateTask(TaskRequestDto taskRequestDto) {
        return null;
    }

    @Override
    public Response<?> deleteTask(Long id) {
        return null;
    }

    @Override
    public Response<?> findTask(Long id) {
        return null;
    }

    @Override
    public Response<?> findAllTasks() {
        List<Task> taskList = taskRepository.findAll();

        return Response.builder()
                .status(200)
                .message("Tasks found")
                .data(taskList)
                .build();
    }
}
