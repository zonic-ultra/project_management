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
