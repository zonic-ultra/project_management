package com.dendev.project_management.service.impl;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.project.ProjectRequestDto;
import com.dendev.project_management.dto.project.ProjectResponseDto;
import com.dendev.project_management.entity.Project;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.exceptions.ResourceNotFoundException;
import com.dendev.project_management.repository.ProjectRepository;
import com.dendev.project_management.service.ProjectService;
import com.dendev.project_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final UserService userService;

    @Override
    public Response<ProjectResponseDto> createProject(ProjectRequestDto projectRequestDto) {

        User user = userService.getCurrentUser();

        Project project = Project.builder()
                .project_name(projectRequestDto.getProject_name())
                .project_description(projectRequestDto.getProject_description())
                .user(user)
                .build();

        Project savedProject = projectRepository.save(project);

        ProjectResponseDto projectResponseDto = new ProjectResponseDto(savedProject);

        return Response.<ProjectResponseDto>builder()
                .status(200)
                .message("Project created successfully")
                .data(projectResponseDto)
                .build();
    }

    @Override
    public Response<ProjectResponseDto> updateProject(Long id, ProjectRequestDto projectRequestDto) {
        Project project = projectRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Project not found"));

        if (project.getProject_name() != null){
            project.setProject_name(projectRequestDto.getProject_name());
        }

        if(project.getProject_description() != null){
            project.setProject_description(projectRequestDto.getProject_description());
        }

        Project projectToUpdate = projectRepository.save(project);

        ProjectResponseDto projectResponseDto = new ProjectResponseDto(projectToUpdate);

        return Response.<ProjectResponseDto>builder()
                .status(200)
                .message("Successfully updated project")
                .data(projectResponseDto)
                .build();
    }

    @Override
    public Response<Void> deleteProject(Long id) {

        Project projectToDelete = projectRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Project not found"));

        projectRepository.delete(projectToDelete);

        return  Response.<Void>builder()
                .status(200)
                .message("Successfully deleted project")
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public Response<List<ProjectResponseDto>> getProjects() {
        List<Project> projects = projectRepository.findAll();

        List<ProjectResponseDto> projectResponse = projects.stream()
                .map(ProjectResponseDto::new)
                .toList();

        return Response.<List<ProjectResponseDto>>builder()
                .status(200)
                .message("Success")
                .data(projectResponse)
                .build();
    }

    @Override
    public Response<ProjectResponseDto> getProject(Long id) {
        Project project = projectRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Project not found"));

        ProjectResponseDto projectResponse = new ProjectResponseDto(project);

        return Response.<ProjectResponseDto>builder()
                .status(200)
                .message("Project found")
                .data(projectResponse)
                .build();
    }
}
