package com.AppDevelopement.Dev.bean;

import java.util.List;

import lombok.Data;

@Data
public class CompanyRequest {
	
	private String companyName;
	private String location;
	
	private List<EmployeeRequest> employees;
	
	
	
	
	
	

}
