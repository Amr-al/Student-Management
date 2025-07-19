package com.example.student_management.controller;

import com.example.student_management.model.Department;
import com.example.student_management.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/all")
    public List<Department> getAllDepartments(){
        return  departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Integer id){
        return departmentRepository.findById(id).get();
    }

    @PostMapping("/create")
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable Integer id, @RequestBody Department department){
        Department newDepartment = departmentRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Department not found"));
        newDepartment.setName(department.getName());
        return departmentRepository.save(newDepartment);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Integer id) {
        departmentRepository.deleteById(id);
        return "Deleted department with id: " + id;
    }
}
