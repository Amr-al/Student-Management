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
    private final StudentRepository studentRepository;
    private final  CourseRepository courseRepository;
    private final  DepartmentRepository departmentRepository;

    StudentController(StudentRepository studentRepository, CourseRepository courseRepository, DepartmentRepository departmentRepository){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentRepository.findById(id).get();

    }

    @PostMapping("/create")
    public Student createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        System.out.println(studentDTO.toString());
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setAge(studentDTO.getAge());

        return studentRepository.save(student);
    }


    @PutMapping("/{studentId}/enroll/courseId")
    public Student enrollStudentInCourses(
            @PathVariable Integer studentId,
            @PathVariable Integer courseId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new RuntimeException("Course not found")
        );
        student.getCourses().add(course);

        return studentRepository.save(student);
    }

}
