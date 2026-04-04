package com.dendev.project_management.controller;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.project.ProjectDto;
import com.dendev.project_management.dto.project.ProjectResponseDto;
import com.dendev.project_management.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<Response<?>>  getAllProjects() {
        return ResponseEntity.ok(projectService.getProjects());
    }

    @PostMapping("/create")
    public ResponseEntity<Response<?>> createProject(@RequestBody @Valid ProjectResponseDto projectResponseDto){
        return ResponseEntity.ok(projectService.createProject(projectResponseDto));
    }

    @PutMapping("/update")
    public ResponseEntity<Response<?>> updateProject(@RequestParam("id") Long id, @RequestBody @Valid ProjectDto projectDto){
        return ResponseEntity.ok(projectService.updateProject(id, projectDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Response<?>> deleteProject(@RequestParam("id") Long id){
        return ResponseEntity.ok(projectService.deleteProject(id));
    }
}
