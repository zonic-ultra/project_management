package com.dendev.project_management.repository;

import com.dendev.project_management.entity.ChangeLog;
import com.dendev.project_management.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChangeLogRepository extends JpaRepository<ChangeLog, Long> {
    List<ChangeLog> findByTaskOrderByChangeAtDesc(Task task);
}
