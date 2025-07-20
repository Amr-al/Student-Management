package com.example.student_management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO {

    @NotBlank(message = "Course name is required")
    private String name;

    @NotNull(message = "Department ID is required")
    private Integer departmentId;
}
