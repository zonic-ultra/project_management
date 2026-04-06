package com.dendev.project_management.service.impl;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.change_log.ChangeLogResponseDto;
import com.dendev.project_management.dto.task.TaskRequestDto;
import com.dendev.project_management.dto.task.TaskResponseDto;
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

    @Autowired
    private ChangeLogService changeLogService;

    @Override
    public Response<TaskResponseDto> createTask(TaskRequestDto taskRequestDto) {
        User user = userRepository.findById(taskRequestDto.getUser_id())
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));

        Project project = projectRepository.findById(taskRequestDto.getProject_id())
                .orElseThrow(()-> new ResourceNotFoundException("Project not found"));

        Task task = Task.builder()
                .task_name(taskRequestDto.getTask_name())
                .contents(taskRequestDto.getContents())
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
    public Response<TaskResponseDto> updateTask(Long id, TaskRequestDto taskRequestDto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Task not found"));

        Project project = projectRepository.findById(taskRequestDto.getProject_id())
                .orElseThrow(()-> new ResourceNotFoundException("Project not found"));

        User user = userRepository.findById(taskRequestDto.getProject_id())
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));


        if (task.getProject() != null) {
            task.setProject(project);
        }
        if (task.getAssignedUser() != null) {
            task.setAssignedUser(user);
        }
        if (task.getTask_name() != null) {
            task.setTask_name(taskRequestDto.getTask_name());
        }
        if (task.getContents() != null) {
            task.setContents(taskRequestDto.getContents());
        }
        if (task.getTaskStatus() != null) {
            task.setTaskStatus(taskRequestDto.getTaskStatus());
        }
        if (task.getDueDate() != null) {
            task.setDueDate(taskRequestDto.getDueDate());
        }

        Task taskToSave =  taskRepository.save(task);

        TaskResponseDto responseDto = new TaskResponseDto(taskToSave);

        return Response.<TaskResponseDto>builder()
                .status(200)
                .message("Task updated")
                .data(responseDto)
                .build();


    }

    @Override
    public Response<Void> deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Task not found"));

        taskRepository.delete(task);

        return Response.<Void>builder()
                .status(200)
                .message("Task deleted")
                .build();
    }

    @Override
    public Response<TaskResponseDto> findTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Task not found"));

        TaskResponseDto responseDto = new TaskResponseDto(task);

        return Response.<TaskResponseDto>builder()
                .status(200)
                .message("Task found")
                .data(responseDto)
                .build();
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

    @Override
    public Response<TaskResponseDto> updateTaskStatus(Long id,String username, TaskRequestDto taskRequestDto, String remark) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Task not found"));



        TaskStatus oldStatus = taskRequestDto.getTaskStatus();
        task.updateTaskStatus(taskRequestDto.getTaskStatus());

        Task updatedTask = taskRepository.save(task);

        TaskResponseDto responseDto = new TaskResponseDto(updatedTask);

        changeLogService.logStatusChange(updatedTask,username,oldStatus,taskRequestDto.getTaskStatus(),remark);


        return Response.<TaskResponseDto>builder()
                .status(200)
                .message("Task status updated")
                .data(responseDto)
                .build();
    }
}
