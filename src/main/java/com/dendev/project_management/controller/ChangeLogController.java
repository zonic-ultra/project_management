package com.dendev.project_management.controller;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.change_log.ChangeLogResponseDto;
import com.dendev.project_management.service.ChangeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "https://project-management-dendev.vercel.app")
@RequestMapping("/api/change_logs")
public class ChangeLogController {

    @Autowired
    private ChangeLogService changeLogService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<List<ChangeLogResponseDto>>> getAllChangeLogs() {
        return ResponseEntity.ok(changeLogService.getChangeLogs());
    }

    @GetMapping("/get_change_log")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<List<ChangeLogResponseDto>>> getChangeLogs(@RequestParam("id") Long id) {
        return ResponseEntity.ok(changeLogService.getTaskHistory(id));
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<Void>> log(@RequestParam("id") Long id){
        return ResponseEntity.ok(changeLogService.deleteLog(id));
    }

}
