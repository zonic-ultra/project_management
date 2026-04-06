package com.dendev.project_management.controller;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.task.TaskRequestDto;
import com.dendev.project_management.dto.task.TaskResponseDto;
import com.dendev.project_management.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<Response<List<TaskResponseDto>>> findAllTasks() {
        return ResponseEntity.ok(taskService.findAllTasks());
    }

    @GetMapping("/find_by_id")
    public ResponseEntity<Response<TaskResponseDto>> findTaskById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(taskService.findTask(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Response<TaskResponseDto>> createTask(@RequestBody @Valid TaskRequestDto taskRequestDto) {
        return ResponseEntity.ok(taskService.createTask(taskRequestDto));
    }

    @PutMapping("/update")
    public ResponseEntity<Response<TaskResponseDto>> updateTask(@RequestParam("id") Long id, @RequestBody @Valid TaskRequestDto taskRequestDto) {
        return ResponseEntity.ok(taskService.updateTask(id, taskRequestDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Response<Void>> deleteTask(@RequestParam("id") Long id) {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }
}
