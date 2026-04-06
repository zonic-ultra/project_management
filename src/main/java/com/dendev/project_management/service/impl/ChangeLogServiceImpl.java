package com.dendev.project_management.service.impl;

import com.dendev.project_management.dto.Response;
import com.dendev.project_management.dto.change_log.ChangeLogResponseDto;
import com.dendev.project_management.entity.ChangeLog;
import com.dendev.project_management.entity.Task;
import com.dendev.project_management.entity.User;
import com.dendev.project_management.enums.TaskStatus;
import com.dendev.project_management.exceptions.ResourceNotFoundException;
import com.dendev.project_management.repository.ChangeLogRepository;
import com.dendev.project_management.repository.UserRepository;
import com.dendev.project_management.service.ChangeLogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChangeLogServiceImpl implements ChangeLogService {

    private ChangeLogRepository changeLogRepository;
    private UserRepository userRepository;

    @Override
    public Response<Void> logChange(Task task, String username, ChangeLog changeLog) {
        User changedBy = userRepository.findByUsername(username)
                .orElseThrow(()->new ResourceNotFoundException("User not found"));

        ChangeLog log = new ChangeLog();
        log.setChangedBy(changedBy);
        log.setAction(changeLog.getAction());
        log.setOld_status(changeLog.getOld_status());
        log.setNew_status(changeLog.getNew_status());
        log.setRemarks(changeLog.getRemarks());
        log.setChangedAt(changeLog.getChangedAt());

        changeLogRepository.save(log);

        return Response.<Void>builder()
                .status(200)
                .message("Changed Successfully")
                .build();
    }

    @Override
    public Response<ChangeLog> findById(Long id) {
        return null;
    }

    @Override
    public Response<Void> logStatusChange(Task task, String username, TaskStatus oldStatus, TaskStatus newStatus, String remark) {
        User changedBy = userRepository.findByUsername(username)
                .orElseThrow(()->new ResourceNotFoundException("User not found"));

        ChangeLog log = new ChangeLog();
        log.setChangedBy(changedBy);
        log.setAction("STATUS_CHANGE");
        log.setOld_status(oldStatus !=null ? oldStatus.name() : null);
        log.setNew_status(newStatus.name());
        log.setRemarks(remark);
//        log.setChangedAt(changeLog.getChangedAt());

        changeLogRepository.save(log);

        return Response.<Void>builder()
                .status(200)
                .message("Changed Successfully")
                .build();
    }

    @Override
    public Response<List<ChangeLogResponseDto>> getTaskHistory() {
        List<ChangeLog> list = changeLogRepository.findAll();

        List<ChangeLogResponseDto> changeLogResponseDtoList = list.stream()
                .map(ChangeLogResponseDto::new).toList();

        return Response.<List<ChangeLogResponseDto>>builder()
                .status(200)
                .message("Success")
                .data(changeLogResponseDtoList)
                .build();
    }
}
