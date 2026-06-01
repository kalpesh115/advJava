package com.AppDevelopement.Dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppDevelopement.Dev.bean.CompanyRequest;
import com.AppDevelopement.Dev.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	@Autowired
	CompanyService companyservice;

	
	@PostMapping("/create")
	public String saveCompany(@RequestBody CompanyRequest request) {
		return companyservice.saveCompany(request);
	}
	
	@GetMapping("/getAll")
	public String getAllCompany() {
		return companyservice.getAllComapany();
	}
	
	@GetMapping("/getById/{id}")
	public String getCompanyId(@PathVariable int id) {
		return companyservice.getCompanyId(id);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteCompany(@PathVariable int id) {
		return companyservice.deleteCompany(id);
		
	}
	@GetMapping("/getByName/{companyName}")
	public String getCompanyByName(@PathVariable String companyName) {

	    return companyservice.getCompanyByName(companyName);
	}
}
