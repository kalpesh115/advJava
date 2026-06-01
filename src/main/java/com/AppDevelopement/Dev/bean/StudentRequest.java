package com.AppDevelopement.Dev.bean;

import lombok.Data;
@Data
public class StudentRequest {
	
	
	private int id;
	private String name;
	private int age;
	private String email;
	
	private AddressRequest address;
	

}
