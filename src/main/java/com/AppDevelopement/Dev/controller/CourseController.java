package com.AppDevelopement.Dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.AppDevelopement.Dev.entity.Course;
import com.AppDevelopement.Dev.repository.CourseRepo;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepo courseRepo;

    @PostMapping("/create")
    public Course saveCourse(
    @RequestBody Course course){

        return courseRepo.save(course);
    }

    @GetMapping("/getAll")
    public List<Course> getAll(){

        return courseRepo.findAll();
    }
}