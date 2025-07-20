package com.example.student_management.controller;

import com.example.student_management.model.Course;
import com.example.student_management.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public  Course getCourseById(@PathVariable Integer id){
        return  courseRepository.findById(id).get();
    }

    @PostMapping("/create")
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

}
