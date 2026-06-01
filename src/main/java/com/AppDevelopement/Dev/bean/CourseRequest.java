package com.AppDevelopement.Dev.bean;

import lombok.Data;

@Data
public class CourseRequest {

    private String courseName;

    private double fees;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }
}