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
