package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.project.ProjectDto;
import com.dendev.project_management.dto.project.ProjectResponseDto;


public interface ProjectService {
    Response<?> updateProject(Long id, ProjectDto projectDto);
    Response<?> deleteProject(Long id);
    Response<?> getProjects();
    Response<?> createProject(ProjectResponseDto projectResponseDto);
}
