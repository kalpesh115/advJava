package com.AppDevelopement.Dev.entity;




import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String companyName;
	private String location;
	
	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
	
	@JsonManagedReference
	private List<Employee> employees;

	

}
