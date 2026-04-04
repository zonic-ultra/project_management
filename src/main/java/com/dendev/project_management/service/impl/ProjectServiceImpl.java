package com.dendev.project_management.service.impl;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.project.ProjectRequestDto;
import com.dendev.project_management.entity.Project;
import com.dendev.project_management.exceptions.ResourceNotFoundException;
import com.dendev.project_management.repository.ProjectRepository;
import com.dendev.project_management.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Response<?> updateProject(Long id, ProjectRequestDto projectRequestDto) {
        Project project = projectRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Project not found"));

        if (project.getProject_name() != null){
            project.setProject_name(projectRequestDto.getProject_name());
        }

        if(project.getProject_description() != null){
            project.setProject_description(projectRequestDto.getProject_description());
        }

        projectRepository.save(project);

        return Response.builder()
                .status(200)
                .message("Successfully updated project")
                .data(project)
                .build();
    }

    @Override
    public Response<?> deleteProject(Long id) {

        Project projectToDelete = projectRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Project not found"));

        projectRepository.delete(projectToDelete);

        return  Response.builder()
                .status(200)
                .message("Successfully deleted project")
                .build();
    }

    @Override
    public Response<?> getProjects() {
        List<Project> projects = projectRepository.findAll();

        return Response.builder()
                .status(200)
                .message("Success")
                .data(projects)
                .build();
    }

    @Override
    public Response<?> createProject(ProjectRequestDto projectRequestDto) {


        Project project = Project.builder()
                .project_name(projectRequestDto.getProject_name())
                .project_description(projectRequestDto.getProject_description())
                .build();

        Project savedProject = projectRepository.save(project);

        return Response.builder()
                .status(200)
                .message("Project created successfully")
                .data(savedProject)
                .build();
    }
}
