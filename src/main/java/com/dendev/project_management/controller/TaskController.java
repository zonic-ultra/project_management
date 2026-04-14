package com.dendev.project_management.controller;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.change_log.ChangeLogDto;
import com.dendev.project_management.dto.change_log.ChangeLogResponseDto;
import com.dendev.project_management.dto.task.TaskRequestDto;
import com.dendev.project_management.dto.task.TaskResponseDto;
import com.dendev.project_management.enums.TaskStatus;
import com.dendev.project_management.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "https://project-management-dendev.vercel.app")
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/total_tasks")
    public ResponseEntity<Long> getTotalTask(){
        return ResponseEntity.ok(taskService.getTotalTasks());
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<Response<List<TaskResponseDto>>> findAllTasks() {
        return ResponseEntity.ok(taskService.findAllTasks());
    }

    @GetMapping("/find_by_id")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<Response<TaskResponseDto>> findTaskById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(taskService.findTask(id));
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<TaskResponseDto>> createTask(@RequestBody @Valid TaskRequestDto taskRequestDto) {
        return ResponseEntity.ok(taskService.createTask(taskRequestDto));
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<TaskResponseDto>> updateTask(@RequestParam("id") Long id, @RequestBody @Valid TaskRequestDto taskRequestDto) {
        return ResponseEntity.ok(taskService.updateTask(id, taskRequestDto));
    }
    @PatchMapping("/update_status")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<Response<ChangeLogResponseDto>> updateTaskStatus(@RequestParam("id") Long id, @RequestBody ChangeLogDto changeLogDto) {
        return ResponseEntity.ok(taskService.updateTaskStatus(id, changeLogDto));
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<Void>> deleteTask(@RequestParam("id") Long id) {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }
}
