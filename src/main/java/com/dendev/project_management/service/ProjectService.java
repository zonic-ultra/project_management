package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.project.ProjectRequestDto;


public interface ProjectService {
    Response<?> updateProject(Long id, ProjectRequestDto projectRequestDto);
    Response<?> deleteProject(Long id);
    Response<?> getProjects();
    Response<?> createProject(ProjectRequestDto projectRequestDto);
}
