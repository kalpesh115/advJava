package com.AppDevelopement.Dev.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="student_name")
    private String name;
    @Column(name="student_age")
    private int age;
 
  @Column(name="student_email")  
    private String email;
  @Column(name="student_monno") 
    private long mobNo;
  
  
  @OneToOne(cascade = CascadeType.ALL)

  @JoinColumn(name = "address_id")
  @JsonIgnore
  private Address address;
  
}