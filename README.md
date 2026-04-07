Repository: zonic-ultra/project_management

================================================
FILE: HELP.md
================================================
# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/4.0.5/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.0.5/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/4.0.5/reference/web/servlet.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/4.0.5/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Validation](https://docs.spring.io/spring-boot/4.0.5/reference/io/validation.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.




================================================
FILE: pom.xml
================================================
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>4.0.5</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.dendev</groupId>
	<artifactId>project_management</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name/>
	<description/>
	<url/>
	<licenses>
		<license/>
	</licenses>
	<developers>
		<developer/>
	</developers>
	<scm>
		<connection/>
		<developerConnection/>
		<tag/>
		<url/>
	</scm>
	<properties>
		<java.version>21</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-webmvc</artifactId>
		</dependency>

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-webmvc-test</artifactId>
			<scope>test</scope>
		</dependency>


		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security-test</artifactId>
			<scope>test</scope>
		</dependency>
		<!-- Source: https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-impl -->
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-impl</artifactId>
			<version>0.13.0</version>
			<scope>runtime</scope>
		</dependency>
		<!-- Source: https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-jackson -->
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-jackson</artifactId>
			<version>0.13.0</version>
			<scope>runtime</scope>
		</dependency>
		<!-- Source: https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api -->
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-api</artifactId>
			<version>0.13.0</version>
			<scope>compile</scope>
		</dependency>


		<!-- swagger -->
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.2.0</version> <!-- Use the latest version available -->
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<executions>
					<execution>
						<id>default-compile</id>
						<phase>compile</phase>
						<goals>
							<goal>compile</goal>
						</goals>
						<configuration>
							<annotationProcessorPaths>
								<path>
									<groupId>org.projectlombok</groupId>
									<artifactId>lombok</artifactId>
								</path>
							</annotationProcessorPaths>
						</configuration>
					</execution>
					<execution>
						<id>default-testCompile</id>
						<phase>test-compile</phase>
						<goals>
							<goal>testCompile</goal>
						</goals>
						<configuration>
							<annotationProcessorPaths>
								<path>
									<groupId>org.projectlombok</groupId>
									<artifactId>lombok</artifactId>
								</path>
							</annotationProcessorPaths>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>

</project>



================================================
FILE: src/main/java/com/dendev/project_management/ProjectManagementApplication.java
================================================
package com.dendev.project_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

}



================================================
FILE: src/main/java/com/dendev/project_management/config/JpaAuditingConfig.java
================================================
package com.dendev.project_management.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig {
}



================================================
FILE: src/main/java/com/dendev/project_management/controller/AuthController.java
================================================
package com.dendev.project_management.controller;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.auth.LoginRequest;
import com.dendev.project_management.dto.auth.RegisterRequest;
import com.dendev.project_management.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Response<?>> register(@RequestBody @Valid RegisterRequest registerRequest){
        return ResponseEntity.ok(authService.signUp(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody @Valid LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }

}



================================================
FILE: src/main/java/com/dendev/project_management/controller/ChangeLogController.java
================================================
package com.dendev.project_management.controller;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.change_log.ChangeLogResponseDto;
import com.dendev.project_management.service.ChangeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/change_logs")
public class ChangeLogController {

    @Autowired
    private ChangeLogService changeLogService;

    @GetMapping
    public ResponseEntity<Response<List<ChangeLogResponseDto>>> getAllChangeLogs() {
        return ResponseEntity.ok(changeLogService.getChangeLogs());
    }

    @GetMapping("/get_change_log")
    public ResponseEntity<Response<List<ChangeLogResponseDto>>> getChangeLogs(@RequestParam Long id) {
        return ResponseEntity.ok(changeLogService.getTaskHistory(id));
    }

}



================================================
FILE: src/main/java/com/dendev/project_management/controller/ProjectController.java
================================================
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
    public ResponseEntity<Response<?>>  getAllProjects() {
        return ResponseEntity.ok(projectService.getProjects());
    }

    @PostMapping("/create")
    public ResponseEntity<Response<?>> createProject(@RequestBody @Valid ProjectRequestDto projectRequestDto){
        return ResponseEntity.ok(projectService.createProject(projectRequestDto));
    }

    @PutMapping("/update")
    public ResponseEntity<Response<ProjectResponseDto>> updateProject(@RequestParam("id") Long id, @RequestBody @Valid ProjectRequestDto projectRequestDto){
        return ResponseEntity.ok(projectService.updateProject(id, projectRequestDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Response<Void>> deleteProject(@RequestParam("id") Long id){
        return ResponseEntity.ok(projectService.deleteProject(id));
    }
}



================================================
FILE: src/main/java/com/dendev/project_management/controller/TaskController.java
================================================
package com.dendev.project_management.controller;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.change_log.ChangeLogResponseDto;
import com.dendev.project_management.dto.task.TaskRequestDto;
import com.dendev.project_management.dto.task.TaskResponseDto;
import com.dendev.project_management.enums.TaskStatus;
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
    @PatchMapping("/update_status")
    public ResponseEntity<Response<TaskResponseDto>> updateTaskStatus(@RequestParam("id") Long id, @RequestBody TaskRequestDto taskStatus) {
        return ResponseEntity.ok(taskService.updateTaskStatus(id, taskStatus));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Response<Void>> deleteTask(@RequestParam("id") Long id) {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }
}



================================================
FILE: src/main/java/com/dendev/project_management/controller/UserController.java
================================================
package com.dendev.project_management.controller;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.user.UserResponseDto;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/current")
    public ResponseEntity<User> getCurrentUser() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }

    @GetMapping("/get_all_member")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<List<UserResponseDto>>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllMembers());
    }

    @GetMapping("/get_member")
    public ResponseEntity<Response<UserResponseDto>> getMember(@Param("id") Long id){
        return ResponseEntity.ok(userService.getMember(id));
    }

    @DeleteMapping("/delete_member")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<Void>> deleteUser(@RequestParam("id") Long id){
        return ResponseEntity.ok(userService.deleteMember(id));
    }


}



================================================
FILE: src/main/java/com/dendev/project_management/dto/Response.java
================================================
package com.dendev.project_management.dto;

import com.dendev.project_management.enums.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T>{
    private int status;
    private String message;
    private T data;
}



================================================
FILE: src/main/java/com/dendev/project_management/dto/auth/LoginRequest.java
================================================
package com.dendev.project_management.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @Email
    @NotBlank(message = "Username is required!")
    private String username;

    @NotBlank(message = "Password is required!")
    private String password;
}



================================================
FILE: src/main/java/com/dendev/project_management/dto/auth/RegisterRequest.java
================================================
package com.dendev.project_management.dto.auth;

import com.dendev.project_management.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterRequest {
    @Email
    @NotBlank(message = "Username is required!")
    private String username;

    @NotBlank(message = "Password is required!")
    private String password;

    @NotBlank(message = "Name is required!")
    private String name;

    private Role role;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
}



================================================
FILE: src/main/java/com/dendev/project_management/dto/change_log/ChangeLogDto.java
================================================
package com.dendev.project_management.dto.change_log;

import com.dendev.project_management.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChangeLogDto {
    private Long taskId;
    private TaskStatus newStatus;
    private String remarks;
}



================================================
FILE: src/main/java/com/dendev/project_management/dto/change_log/ChangeLogResponseDto.java
================================================
package com.dendev.project_management.dto.change_log;

import com.dendev.project_management.entity.ChangeLog;
import com.dendev.project_management.entity.Task;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.enums.TaskStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class ChangeLogResponseDto {
    private Long id;
    private Long taskId;
    private String taskName;
    private String projectName;
    private String username;
    private LocalDateTime changedAt;
    private String action;
    private TaskStatus newStatus;
    private String remarks;
    private TaskStatus currentTaskStatus;

    public ChangeLogResponseDto(ChangeLog changeLog) {
        this.id = changeLog.getId();
        this.taskId = changeLog.getTask() != null ? changeLog.getTask().getId() : null;
        this.taskName = changeLog.getTask() != null ? changeLog.getTask().getTask_name() : null; // adjust if field name differs
        this.projectName = (changeLog.getTask() != null && changeLog.getTask().getProject() != null)
                ? changeLog.getTask().getProject().getProject_name() : null;
        this.username = changeLog.getChangedBy() != null ? changeLog.getChangedBy().getUsername() : null;
        this.changedAt = changeLog.getChangedAt();
        this.action = changeLog.getAction();
        this.newStatus = changeLog.getNew_status();
        this.remarks = changeLog.getRemarks();
        this.currentTaskStatus = changeLog.getTask() != null ? changeLog.getTask().getTaskStatus() : null;
    }
}



================================================
FILE: src/main/java/com/dendev/project_management/dto/project/ProjectRequestDto.java
================================================
package com.dendev.project_management.dto.project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProjectRequestDto {
    @NotBlank(message = "Project name is required!")
    @Size(min = 2, max = 100, message = "Description must be between 2 and 100 characters")
    private String project_name;

    @Size(min = 2, max = 500, message = "Description must be between 2 and 500 characters")
    private String project_description;
}



================================================
FILE: src/main/java/com/dendev/project_management/dto/project/ProjectResponseDto.java
================================================
package com.dendev.project_management.dto.project;

import com.dendev.project_management.entity.Project;
import com.dendev.project_management.entity.Task;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ProjectResponseDto {
    private Long project_id;
    private String project_name;
    private String project_description;
    private List<Task> tasks;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProjectResponseDto(Project project) {
        this.project_id = project.getProject_id();
        this.project_name = project.getProject_name();
        this.project_description = project.getProject_description();
        this.tasks = project.getTasks();
        this.createdAt = project.getCreatedAt();
        this.updatedAt = project.getUpdatedAt();
    }
}



================================================
FILE: src/main/java/com/dendev/project_management/dto/task/TaskRequestDto.java
================================================
package com.dendev.project_management.dto.task;

import com.dendev.project_management.enums.TaskStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskRequestDto {

    @NotBlank(message = "Task name is required!")
    @Size(min = 2, max = 100, message = "Description must be between 2 and 100 characters")
    private String task_name;

    @Size(min = 2, max = 500, message = "Description must be between 2 and 500 characters")
    private String contents;

    private TaskStatus taskStatus;

    @FutureOrPresent(message = "Due date must be today or in future")
    private LocalDate dueDate;

    @NotNull
    private Long user_id;

    @NotNull
    private Long project_id;

    private String remarks;
}



================================================
FILE: src/main/java/com/dendev/project_management/dto/task/TaskResponseDto.java
================================================
package com.dendev.project_management.dto.task;

import com.dendev.project_management.entity.Task;
import com.dendev.project_management.enums.TaskStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TaskResponseDto {
    private Long id;
    private String task_name;
    private String contents;
    private TaskStatus taskStatus;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Long project_id;
    private String project_name;

    private Long user_id;
    private String username;

    public TaskResponseDto(Task task) {
        this.id = task.getId();
        this.task_name = task.getTask_name();
        this.contents = task.getContents();
        this.taskStatus = task.getTaskStatus();
        this.dueDate = task.getDueDate();
        this.createdAt = task.getCreatedAt();
        this.updatedAt = task.getUpdatedAt();

        if (task.getProject() != null) {
            this.project_id = task.getProject().getProject_id();
            this.project_name = task.getProject().getProject_name();
        }

        if (task.getAssignedUser() != null) {
            this.user_id = task.getAssignedUser().getId();
            this.username = task.getAssignedUser().getName();
        }
    }
}



================================================
FILE: src/main/java/com/dendev/project_management/dto/user/UserDto.java
================================================
package com.dendev.project_management.dto.user;

import com.dendev.project_management.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {
    @Email
    @NotBlank(message = "Username is required!")
    private String username;

    @NotBlank(message = "Password is required!")
    private String password;

    @NotBlank(message = "Name is required!")
    private String name;

    private Role role;
}



================================================
FILE: src/main/java/com/dendev/project_management/dto/user/UserResponseDto.java
================================================
package com.dendev.project_management.dto.user;

import com.dendev.project_management.entity.User;
import com.dendev.project_management.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Data
public class UserResponseDto {
    private Long id;
    private String username;
    private String name;
    private Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
        this.role = user.getRole();
        this.createdAt = user.getCreatedAt();
    }
}



================================================
FILE: src/main/java/com/dendev/project_management/entity/ChangeLog.java
================================================
package com.dendev.project_management.entity;

import com.dendev.project_management.enums.TaskStatus;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "change_logs")
@EntityListeners(AuditingEntityListener.class)
public class ChangeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "changed_by_id", nullable = false)
    private User changedBy;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime changedAt =  LocalDateTime.now();

    private String action;

    @Enumerated(EnumType.STRING)
    private TaskStatus new_status;

    @Column(length = 500)
    private String remarks;
}



================================================
FILE: src/main/java/com/dendev/project_management/entity/Project.java
================================================
package com.dendev.project_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects")
@EntityListeners(AuditingEntityListener.class)
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long project_id;

    @Column(nullable = false, unique = true)
    private String project_name;

    @Column(nullable = false)
    private String project_description;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
}



================================================
FILE: src/main/java/com/dendev/project_management/entity/Task.java
================================================
package com.dendev.project_management.entity;


import com.dendev.project_management.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
@EntityListeners(AuditingEntityListener.class)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String task_name;

    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    @JsonIgnore
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User assignedUser;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus = TaskStatus.TODO;

    @FutureOrPresent
    private LocalDate dueDate;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChangeLog> changeLogs = new ArrayList<>();

}



================================================
FILE: src/main/java/com/dendev/project_management/entity/User.java
================================================
package com.dendev.project_management.entity;

import com.dendev.project_management.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy ="user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects = new ArrayList<>();
}




================================================
FILE: src/main/java/com/dendev/project_management/enums/Role.java
================================================
package com.dendev.project_management.enums;


public enum Role {
 USER, ADMIN
}



================================================
FILE: src/main/java/com/dendev/project_management/enums/TaskStatus.java
================================================
package com.dendev.project_management.enums;

public enum TaskStatus {
    TODO,IN_PROGRESS,DONE
}



================================================
FILE: src/main/java/com/dendev/project_management/exceptions/BadRequestException.java
================================================
package com.dendev.project_management.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}



================================================
FILE: src/main/java/com/dendev/project_management/exceptions/GlobalExceptionHandler.java
================================================
package com.dendev.project_management.exceptions;

import com.dendev.project_management.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<?>> handleAllUnknownException(Exception ex) {
        Response<?> response = Response.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response<?>> handleNotFoundException(ResourceNotFoundException ex) {
        Response<?> response = Response.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Response<?>>
    handleBadRequestException(BadRequestException ex) {
        Response<?> response = Response.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Response<?>> handleInvalidCredentialsException(InvalidCredentialsException ex) {
        Response<?> response = Response.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}



================================================
FILE: src/main/java/com/dendev/project_management/exceptions/InvalidCredentialsException.java
================================================
package com.dendev.project_management.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}



================================================
FILE: src/main/java/com/dendev/project_management/exceptions/ResourceNotFoundException.java
================================================
package com.dendev.project_management.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}



================================================
FILE: src/main/java/com/dendev/project_management/repository/ChangeLogRepository.java
================================================
package com.dendev.project_management.repository;

import com.dendev.project_management.entity.ChangeLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChangeLogRepository extends JpaRepository<ChangeLog, Long> {
    List<ChangeLog> findByTaskIdOrderByChangedAtDesc(Long taskId);

    List<ChangeLog> findAllByOrderByChangedAtDesc();
}



================================================
FILE: src/main/java/com/dendev/project_management/repository/ProjectRepository.java
================================================
package com.dendev.project_management.repository;

import com.dendev.project_management.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}



================================================
FILE: src/main/java/com/dendev/project_management/repository/TaskRepository.java
================================================
package com.dendev.project_management.repository;

import com.dendev.project_management.entity.Task;
import com.dendev.project_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignedUser(User user);
}



================================================
FILE: src/main/java/com/dendev/project_management/repository/UserRepository.java
================================================
package com.dendev.project_management.repository;

import com.dendev.project_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    User findUserById(Long id);
}



================================================
FILE: src/main/java/com/dendev/project_management/security/AuthFilter.java
================================================
package com.dendev.project_management.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuthFilter extends OncePerRequestFilter {
    private final JwtUtils jwtUtils;

    private final CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String token = getTokenFromRequest(request);

        if (token != null) {
            String username = jwtUtils.getUsernameFromToken(token);

            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

            if (jwtUtils.isValidToken(token, userDetails)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        try{
            filterChain.doFilter(request, response);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String tokenWithBearer = request.getHeader("Authorization");

        if(tokenWithBearer != null && tokenWithBearer.startsWith("Bearer ")){
            return tokenWithBearer.substring(7);
        }
        return  null;
    }


}



================================================
FILE: src/main/java/com/dendev/project_management/security/AuthUser.java
================================================
package com.dendev.project_management.security;

import com.dendev.project_management.entity.User;
import lombok.Builder;
import lombok.Data;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


@Data
@Builder
public class AuthUser implements UserDetails {

    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()));
    }

    @Override
    public @Nullable String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}



================================================
FILE: src/main/java/com/dendev/project_management/security/CorsConfig.java
================================================
package com.dendev.project_management.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new  WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/api/**")
                            .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                            .allowedOrigins("*")
                            .allowedHeaders("*");
                }
        };
    }
}



================================================
FILE: src/main/java/com/dendev/project_management/security/CustomUserDetailsService.java
================================================
package com.dendev.project_management.security;

import com.dendev.project_management.entity.User;
import com.dendev.project_management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUsername(username)
               .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

       return AuthUser.builder()
               .user(user)
               .build();
    }
}



================================================
FILE: src/main/java/com/dendev/project_management/security/JwtUtils.java
================================================
package com.dendev.project_management.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

@Service
@Slf4j
public class JwtUtils {
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    private SecretKey secretKey;

    @Value("${secretJwtString}")
    private String jwtSecret;

    @PostConstruct
    private void init(){
        byte[] keyByte = jwtSecret.getBytes(StandardCharsets.UTF_8);
        this.secretKey = new SecretKeySpec(keyByte, "HmacSHA256");
    }

    public String generateToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(secretKey)
                .compact();
    }

    public String getUsernameFromToken(String token){
        return extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction){
        return  claimsTFunction.apply(Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload());
    }

    public boolean isValidToken(String token, UserDetails userDetails){
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token){
        return extractClaims(token, Claims::getExpiration).before(new Date());
    }
}



================================================
FILE: src/main/java/com/dendev/project_management/security/SecurityFilterConfig.java
================================================
package com.dendev.project_management.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityFilterConfig {

    private final AuthFilter authFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(req -> req.requestMatchers("/api/auth/**").permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}



================================================
FILE: src/main/java/com/dendev/project_management/service/AuthService.java
================================================
package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.auth.LoginRequest;
import com.dendev.project_management.dto.auth.RegisterRequest;

public interface AuthService {
    Response<?> signUp(RegisterRequest registerRequest);
    Response<?> login(LoginRequest loginRequest);
}



================================================
FILE: src/main/java/com/dendev/project_management/service/ChangeLogService.java
================================================
package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.change_log.ChangeLogDto;
import com.dendev.project_management.dto.change_log.ChangeLogResponseDto;
import com.dendev.project_management.entity.ChangeLog;
import com.dendev.project_management.entity.Task;
import com.dendev.project_management.enums.TaskStatus;

import java.util.List;

public interface ChangeLogService {
    Response<ChangeLogResponseDto> createChangeLog(ChangeLogDto dto);

    void logStatusChange(Long taskId, TaskStatus newStatus, String remarks);

    Response<List<ChangeLogResponseDto>> getTaskHistory(Long taskId);

    Response<List<ChangeLogResponseDto>> getChangeLogs();
}


================================================
FILE: src/main/java/com/dendev/project_management/service/ProjectService.java
================================================
package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.project.ProjectRequestDto;
import com.dendev.project_management.dto.project.ProjectResponseDto;

import java.util.List;


public interface ProjectService {
    Response<ProjectResponseDto> updateProject(Long id, ProjectRequestDto projectRequestDto);
    Response<Void> deleteProject(Long id);
    Response<?> getProjects();
    Response<ProjectResponseDto> createProject(ProjectRequestDto projectRequestDto);
}



================================================
FILE: src/main/java/com/dendev/project_management/service/TaskService.java
================================================
package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.change_log.ChangeLogResponseDto;
import com.dendev.project_management.dto.task.TaskRequestDto;
import com.dendev.project_management.dto.task.TaskResponseDto;
import com.dendev.project_management.enums.TaskStatus;

import java.util.List;

public interface TaskService {
    Response<TaskResponseDto> createTask(TaskRequestDto dto);
    Response<TaskResponseDto> updateTask(Long id, TaskRequestDto dto);
    Response<Void> deleteTask(Long id);
    Response<TaskResponseDto> findTask(Long id);
    Response<List<TaskResponseDto>> findAllTasks();
    Response<TaskResponseDto> updateTaskStatus(Long id, TaskRequestDto taskRequestDto);
}



================================================
FILE: src/main/java/com/dendev/project_management/service/UserService.java
================================================
package com.dendev.project_management.service;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.auth.LoginRequest;
import com.dendev.project_management.dto.auth.RegisterRequest;
import com.dendev.project_management.dto.user.UserDto;
import com.dendev.project_management.dto.user.UserResponseDto;
import com.dendev.project_management.entity.User;

import java.util.List;

public interface UserService {
//    Response<?>  signUp(RegisterRequest registerRequest);
//    Response<?> login(LoginRequest loginRequest);
    Response<List<UserResponseDto>>  getAllMembers();
    User getCurrentUser();
    Response<?> updateMember(Long id, UserDto userDto);
    Response<Void> deleteMember(Long id);
    Response<UserResponseDto> getMember(Long id);
}



================================================
FILE: src/main/java/com/dendev/project_management/service/impl/AuthServiceImpl.java
================================================
package com.dendev.project_management.service.impl;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.auth.LoginRequest;
import com.dendev.project_management.dto.auth.RegisterRequest;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.enums.Role;
import com.dendev.project_management.exceptions.BadRequestException;
import com.dendev.project_management.repository.UserRepository;
import com.dendev.project_management.security.JwtUtils;
import com.dendev.project_management.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;

    @Override
    public Response<User> signUp(RegisterRequest registerRequest) {
        Optional<User> existingUser = userRepository.findByUsername(registerRequest.getUsername());

        if (existingUser.isPresent()){
            throw new BadRequestException("Username already exists");
        }

        Role role = Role.USER;

        if (registerRequest.getRole() != null) {
            role = registerRequest.getRole();
        }

        User userToSave = User.builder()
                .name(registerRequest.getName())
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(role)
                .createdAt(registerRequest.getCreatedAt())
                .build();
        userRepository.save(userToSave);

        return Response.<User>builder()
                .status(200)
                .data(userToSave)
                .message("User was successfully registered...")
                .build();
    }

    @Override
    public Response<?> login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(()-> new BadRequestException("Username not found"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new BadRequestException("Invalid password");
        }

        String token = jwtUtils.generateToken(user.getUsername());

        return Response.builder()
                .status(200)
                .message("User login successfully")
                .data(token)
                .build();

    }
}



================================================
FILE: src/main/java/com/dendev/project_management/service/impl/ChangeLogServiceImpl.java
================================================
package com.dendev.project_management.service.impl;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.change_log.ChangeLogDto;
import com.dendev.project_management.dto.change_log.ChangeLogResponseDto;
import com.dendev.project_management.entity.ChangeLog;
import com.dendev.project_management.entity.Task;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.enums.TaskStatus;
import com.dendev.project_management.exceptions.ResourceNotFoundException;
import com.dendev.project_management.repository.ChangeLogRepository;
import com.dendev.project_management.repository.TaskRepository;
import com.dendev.project_management.service.ChangeLogService;
import com.dendev.project_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChangeLogServiceImpl implements ChangeLogService {

    private final ChangeLogRepository changeLogRepository;
    private final UserService userService;
    private final TaskRepository taskRepository;

    @Override
    @Transactional
    public Response<ChangeLogResponseDto> createChangeLog(ChangeLogDto dto) {
        Task task = taskRepository.findById(dto.getTaskId())
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        User changedBy = userService.getCurrentUser();

        ChangeLog log = ChangeLog.builder()
                .task(task)
                .changedBy(changedBy)
                .action("STATUS_CHANGED")
                .new_status(dto.getNewStatus())
                .remarks(dto.getRemarks())
                .build();

        ChangeLog savedLog = changeLogRepository.save(log);

        return Response.<ChangeLogResponseDto>builder()
                .status(200)
                .message("Change log created successfully")
                .data(new ChangeLogResponseDto(savedLog))
                .build();
    }

    @Override
    public void logStatusChange(Long taskId, TaskStatus newStatus, String remarks) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        User changedBy = userService.getCurrentUser();

        ChangeLog log = ChangeLog.builder()
                .task(task)
                .changedBy(changedBy)
                .action("STATUS_CHANGED")
                .new_status(newStatus)
                .remarks(remarks)
                .build();

        changeLogRepository.save(log);
    }

    @Override
    public Response<List<ChangeLogResponseDto>> getTaskHistory(Long taskId) {
        List<ChangeLog> logs = changeLogRepository.findByTaskIdOrderByChangedAtDesc(taskId);

        List<ChangeLogResponseDto> list = logs.stream()
                .map(ChangeLogResponseDto::new)
                .toList();

        return Response.<List<ChangeLogResponseDto>>builder()
                .status(200)
                .message("Task history retrieved successfully")
                .data(list)
                .build();
    }

    @Override
    public Response<List<ChangeLogResponseDto>> getChangeLogs() {
        List<ChangeLog> logs = changeLogRepository.findAllByOrderByChangedAtDesc();

        List<ChangeLogResponseDto> dtoList = logs.stream()
                .map(ChangeLogResponseDto::new)
                .toList();

        return Response.<List<ChangeLogResponseDto>>builder()
                .status(200)
                .message("All change logs retrieved successfully")
                .data(dtoList)
                .build();
    }

}


================================================
FILE: src/main/java/com/dendev/project_management/service/impl/ProjectServiceImpl.java
================================================
package com.dendev.project_management.service.impl;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.project.ProjectRequestDto;
import com.dendev.project_management.dto.project.ProjectResponseDto;
import com.dendev.project_management.dto.user.UserResponseDto;
import com.dendev.project_management.entity.Project;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.exceptions.ResourceNotFoundException;
import com.dendev.project_management.repository.ProjectRepository;
import com.dendev.project_management.repository.UserRepository;
import com.dendev.project_management.service.ProjectService;
import com.dendev.project_management.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
    public Response<?> getProjects() {
        List<Project> projects = projectRepository.findAll();



        return Response.builder()
                .status(200)
                .message("Success")
                .data(projects)
                .build();
    }
}



================================================
FILE: src/main/java/com/dendev/project_management/service/impl/TaskServiceImpl.java
================================================
package com.dendev.project_management.service.impl;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.change_log.ChangeLogDto;
import com.dendev.project_management.dto.change_log.ChangeLogResponseDto;
import com.dendev.project_management.dto.task.TaskRequestDto;
import com.dendev.project_management.dto.task.TaskResponseDto;
import com.dendev.project_management.entity.ChangeLog;
import com.dendev.project_management.entity.Project;
import com.dendev.project_management.entity.Task;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.enums.Role;
import com.dendev.project_management.enums.TaskStatus;
import com.dendev.project_management.exceptions.ResourceNotFoundException;
import com.dendev.project_management.repository.ProjectRepository;
import com.dendev.project_management.repository.TaskRepository;
import com.dendev.project_management.repository.UserRepository;
import com.dendev.project_management.service.ChangeLogService;
import com.dendev.project_management.service.TaskService;
import com.dendev.project_management.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final ChangeLogService changeLogService;

    @Override
    @Transactional
    public Response<TaskResponseDto> createTask(TaskRequestDto dto) {
        // 1. Find assigned user
        User assignedUser = userRepository.findById(dto.getUser_id())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // 2. Find project
        Project project = projectRepository.findById(dto.getProject_id())
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

        // 3. Build and save task
        Task task = Task.builder()
                .task_name(dto.getTask_name())
                .contents(dto.getContents())
                .taskStatus(dto.getTaskStatus() != null ? dto.getTaskStatus() : TaskStatus.TODO)
                .dueDate(dto.getDueDate())
                .project(project)
                .assignedUser(assignedUser)
                .build();

        Task savedTask = taskRepository.save(task);

        changeLogService.logStatusChange(savedTask.getId(), dto.getTaskStatus(), "Task created successfully");

        return Response.<TaskResponseDto>builder()
                .status(200)
                .message("Task created successfully")
                .data(new TaskResponseDto(savedTask))
                .build();
    }

    @Override
    @Transactional
    public Response<TaskResponseDto> updateTask(Long id, TaskRequestDto dto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        if (dto.getProject_id() != null) {
            Project project = projectRepository.findById(dto.getProject_id())
                    .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
            task.setProject(project);
        }

        if (dto.getUser_id() != null) {
            User user = userRepository.findById(dto.getUser_id())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));
            task.setAssignedUser(user);
        }

        if (dto.getTask_name() != null) task.setTask_name(dto.getTask_name());
        if (dto.getContents() != null) task.setContents(dto.getContents());
        if (dto.getTaskStatus() != null) task.setTaskStatus(dto.getTaskStatus());
        if (dto.getDueDate() != null) task.setDueDate(dto.getDueDate());

        Task updatedTask = taskRepository.save(task);

        changeLogService.logStatusChange(updatedTask.getId(), updatedTask.getTaskStatus(), "Task updated successfully");


        return Response.<TaskResponseDto>builder()
                .status(200)
                .message("Task updated successfully")
                .data(new TaskResponseDto(updatedTask))
                .build();
    }

    @Override
    @Transactional
    public Response<Void> deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        taskRepository.delete(task);

        return Response.<Void>builder()
                .status(200)
                .message("Task deleted successfully")
                .build();
    }

    @Override
    public Response<TaskResponseDto> findTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        return Response.<TaskResponseDto>builder()
                .status(200)
                .message("Task found")
                .data(new TaskResponseDto(task))
                .build();
    }

    @Override
    public Response<List<TaskResponseDto>> findAllTasks() {
        User currentUser = userService.getCurrentUser();
        List<Task> taskList;

        if (currentUser.getRole() == Role.ADMIN) {
            taskList = taskRepository.findAll();
        } else {
            taskList = taskRepository.findByAssignedUser(currentUser);
        }

        List<TaskResponseDto> dtoList = taskList.stream()
                .map(TaskResponseDto::new)
                .toList();

        return Response.<List<TaskResponseDto>>builder()
                .status(200)
                .message("Tasks retrieved successfully")
                .data(dtoList)
                .build();
    }

    @Override
    @Transactional
    public Response<TaskResponseDto> updateTaskStatus(Long id, TaskRequestDto taskRequestDto) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        TaskStatus newStatus = taskRequestDto.getTaskStatus();

        task.setTaskStatus(newStatus);

        Task updatedTask = taskRepository.save(task);


        changeLogService.logStatusChange(
                updatedTask.getId(),
                newStatus,
                taskRequestDto.getRemarks()
        );


        TaskResponseDto responseDto = new TaskResponseDto();
        responseDto.setId(updatedTask.getId());
        responseDto.setTaskStatus(updatedTask.getTaskStatus());

        return Response.<TaskResponseDto>builder()
                .status(200)
                .message("Task status updated successfully")
                .data(responseDto)
                .build();
    }
}





================================================
FILE: src/main/java/com/dendev/project_management/service/impl/UserServiceImpl.java
================================================
package com.dendev.project_management.service.impl;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.auth.LoginRequest;
import com.dendev.project_management.dto.auth.RegisterRequest;
import com.dendev.project_management.dto.user.UserDto;
import com.dendev.project_management.dto.user.UserResponseDto;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.enums.Role;
import com.dendev.project_management.exceptions.BadRequestException;
import com.dendev.project_management.exceptions.ResourceNotFoundException;
import com.dendev.project_management.repository.UserRepository;
import com.dendev.project_management.security.JwtUtils;
import com.dendev.project_management.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Response<List<UserResponseDto>> getAllMembers() {
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.ASC, "username"));

        List<UserResponseDto> userResponse = users.stream()
                .map(UserResponseDto::new)
                .toList();

        return Response.<List<UserResponseDto>>builder()
                .status(200)
                .message("Success")
                .data(userResponse)
                .build();
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        Optional<User> user = Optional.of(userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!")));

        return user.get();
    }


    @Override
    public Response<UserResponseDto> updateMember(Long id, UserDto userDto) {
        User existingUserToUpdate = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found!"));

        if (existingUserToUpdate.getUsername()!= null) {
            existingUserToUpdate.setUsername(userDto.getUsername());
        }

        if (userDto.getPassword() != null && userDto.getPassword().isEmpty()){
            existingUserToUpdate.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }

        if (userDto.getName() != null) {
            existingUserToUpdate.setName(userDto.getName());
        }

        if (userDto.getRole() != null){
            existingUserToUpdate.setRole(userDto.getRole());
        }

        userRepository.save(existingUserToUpdate);

        UserResponseDto userResponseDto = new UserResponseDto(existingUserToUpdate);

        return Response.<UserResponseDto>builder()
                .status(200)
                .message("User updated successfully")
                .data(userResponseDto)
                .build();
    }

    @Override
    public Response<Void> deleteMember(Long id) {
        userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found!"));

        userRepository.deleteById(id);

        return Response.<Void>builder()
                .status(200)
                .message("User deleted successfully")
                .build();
    }

    @Override
    public Response<UserResponseDto> getMember(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found!"));
        UserResponseDto userResponseDto = new UserResponseDto(user);
         return Response.<UserResponseDto>builder()
                 .status(200)
                 .message("Member found")
                 .data(userResponseDto)
                 .build();
    }


}



================================================
FILE: src/main/java/com/dendev/project_management/swaggerConfig/WebMvcConfig.java
================================================
package com.dendev.project_management.swaggerConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        // Make Swagger meta-data available via <baseURL>/v2/api-docs/
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        // Make Swagger UI available via <baseURL>/swagger-ui.html
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/");
    }
}



================================================
FILE: src/main/resources/application.properties
================================================
spring.application.name=project_management

spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

#JPA / Hibernate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8082

springdoc.swagger-ui.disable-swagger-default-url=true

secretJwtString={SECRET}



================================================
FILE: src/test/java/com/dendev/project_management/ProjectManagementApplicationTests.java
================================================
package com.dendev.project_management;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectManagementApplicationTests {

	@Test
	void contextLoads() {
	}

}

