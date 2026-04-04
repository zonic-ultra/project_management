package com.dendev.project_management.controller;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.task.TaskRequestDto;
import com.dendev.project_management.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<Response<?>> findAllTasks() {
        return ResponseEntity.ok(taskService.findAllTasks());
    }

    @PostMapping("/create")
    public ResponseEntity<Response<?>> createTask(@RequestBody @Valid TaskRequestDto taskRequestDto) {
        return ResponseEntity.ok(taskService.createTask(taskRequestDto));
    }
}
