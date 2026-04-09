package com.dendev.project_management.controller;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.project.ProjectRequestDto;
import com.dendev.project_management.dto.project.ProjectResponseDto;
import com.dendev.project_management.dto.task.TaskResponseDto;
import com.dendev.project_management.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<List<ProjectResponseDto>>>getAllProjects() {
        return ResponseEntity.ok(projectService.getProjects());
    }

    @GetMapping("/get_project")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<ProjectResponseDto>> getProject(@RequestParam Long id) {
        return ResponseEntity.ok(projectService.getProject(id));
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<?>> createProject(@RequestBody @Valid ProjectRequestDto projectRequestDto){
        return ResponseEntity.ok(projectService.createProject(projectRequestDto));
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<ProjectResponseDto>> updateProject(@RequestParam("id") Long id, @RequestBody @Valid ProjectRequestDto projectRequestDto){
        return ResponseEntity.ok(projectService.updateProject(id, projectRequestDto));
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<Void>> deleteProject(@RequestParam("id") Long id){
        return ResponseEntity.ok(projectService.deleteProject(id));
    }
}
