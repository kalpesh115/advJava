package com.AppDevelopement.Dev.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;

    private String state;

    private String landmark;

    private String street1;

    private String street2;

    private String pincode;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private StudentInfo student;
}