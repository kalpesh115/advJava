package com.AppDevelopement.Dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AppDevelopement.Dev.entity.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	
	 boolean existsByEmail(String email);
	

}
