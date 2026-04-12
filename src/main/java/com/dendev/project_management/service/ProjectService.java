package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.project.ProjectRequestDto;
import com.dendev.project_management.dto.project.ProjectResponseDto;

import java.util.List;


public interface ProjectService {
    Response<ProjectResponseDto> updateProject(Long id, ProjectRequestDto projectRequestDto);
    Response<Void> deleteProject(Long id);
    Response<List<ProjectResponseDto>> getProjects();
    Response<ProjectResponseDto> getProject(Long id);
    Response<ProjectResponseDto> createProject(ProjectRequestDto projectRequestDto);
    long getTotalProjects();
}
