package com.AppDevelopement.Dev.service;

import java.util.List;

import com.AppDevelopement.Dev.bean.StudentRequest;
import com.AppDevelopement.Dev.entity.StudentInfo;

public interface CrudService {

    String saveRecord(StudentRequest request);

    String getById(int id);

    String getByName(String name);

   

    String updateStudentInfo(int id, StudentRequest request);

    


  
	String getByName();

	String getAllUsers(String name);

	String getAllStudents();

	String getAllUsers();

	;

	String deleteStudent(int id);

	

	String deleteById(int id);

	String DeleteById(int id);
	
	

	
}