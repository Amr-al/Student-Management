package com.example.student_management.controller;

import com.example.student_management.dto.StudentDTO;
import com.example.student_management.model.Course;
import com.example.student_management.model.Department;
import com.example.student_management.model.Student;
import com.example.student_management.repository.CourseRepository;
import com.example.student_management.repository.DepartmentRepository;
import com.example.student_management.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;


    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/create")
    public Student createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        Department department = departmentRepository.findById(studentDTO.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setAge(studentDTO.getAge());
        student.setDepartment(department);

        return studentRepository.save(student);
    }

    @PutMapping("/{studentId}/enroll")
    public Student enrollStudentInCourses(
            @PathVariable Integer studentId,
            @RequestBody Integer courseId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId).get();
        student.getCourses().add(course);

        return studentRepository.save(student);
    }

}
