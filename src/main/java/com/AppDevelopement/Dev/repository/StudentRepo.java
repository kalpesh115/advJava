package com.AppDevelopement.Dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AppDevelopement.Dev.entity.StudentInfo;

public interface StudentRepo extends JpaRepository<StudentInfo,Integer> {
	
	Optional<StudentInfo> findByName(String name);
	 

	boolean existsByEmail(String email);
	boolean existsByMobNo(long mobNo);

	
	
	
	

}
