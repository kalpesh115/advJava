package com.AppDevelopement.Dev.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Employee {
	
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   private String employeeName;
   private long salary;
   @Column(unique = true)
   private String email;
   
   @ManyToOne
   @JoinColumn(name="company_id")
   
   
   @JsonBackReference
   private  Company company;
  
}
