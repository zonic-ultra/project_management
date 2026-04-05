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
