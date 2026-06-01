package com.AppDevelopement.Dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AppDevelopement.Dev.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{

}