package com.AppDevelopement.Dev.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Learner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String learnerName;

    private String city;

    @OneToMany(mappedBy = "learner", cascade = CascadeType.ALL)
    private List<Course> courses;
}