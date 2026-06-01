package com.AppDevelopement.Dev.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String courseName;

    private double fees;

    @ManyToOne
    @JoinColumn(name = "learner_id")
    private Learner learner;
}