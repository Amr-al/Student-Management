package com.example.student_management.controller;

import com.example.student_management.model.Course;
import com.example.student_management.model.Department;
import com.example.student_management.model.Professor;
import com.example.student_management.repository.CourseRepository;
import com.example.student_management.repository.DepartmentRepository;
import com.example.student_management.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Professor getProfessor(@PathVariable Integer id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor not found"));
    }

    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @PutMapping("/{id}/department/{deptId}")
    public Professor assignDepartment(@PathVariable Integer id, @PathVariable Integer deptId) {
        Professor professor = professorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Professor not found")
        );

        Department department = departmentRepository.findById(deptId).orElseThrow(
                () -> new RuntimeException("Department not found")
        );

        professor.setDepartment(department);

        return professorRepository.save(professor);
    }

    @PutMapping("/{id}/courses/{courseId}")
    public Professor assignCourse(@PathVariable Integer id, @PathVariable Integer courseId){
        Professor professor = professorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Professor not found")
        );

        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new RuntimeException("Course not found")
        );

        professor.getCourses().add(course);
        return professorRepository.save(professor);
    }

    @DeleteMapping("/{id}")
    public String deleteProfessor(@PathVariable Integer id) {
        professorRepository.deleteById(id);
        return "Deleted professor with id: " + id;
    }

}
