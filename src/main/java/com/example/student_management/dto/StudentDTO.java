package com.example.student_management.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class StudentDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Email is required")
    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 30, message = "The student must be less than or equal to 30")
    private Integer age;

    @NotNull(message = "Department ID is required")
    private Integer departmentId;


}
