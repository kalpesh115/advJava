package com.AppDevelopement.Dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AppDevelopement.Dev.entity.Company;

public interface ComapanyRepo extends JpaRepository<Company, Integer> {
	
    Optional<Company> findByCompanyName(String companyName);
    Optional<Company> findByCompanyNameIgnoreCase(String companyName);


	

}
