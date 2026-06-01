package com.AppDevelopement.Dev.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AppDevelopement.Dev.bean.CompanyRequest;
import com.AppDevelopement.Dev.bean.EmployeeRequest;
import com.AppDevelopement.Dev.entity.Company;
import com.AppDevelopement.Dev.entity.Employee;
import com.AppDevelopement.Dev.repository.ComapanyRepo;
import com.AppDevelopement.Dev.repository.EmployeeRepo;
import com.AppDevelopement.Dev.service.CompanyService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
@Service
public class CompanyServiceImpl implements CompanyService {
 
	@Autowired
	ComapanyRepo companyrepo;
	
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	
	public String saveCompany(CompanyRequest request) {
		
		JsonObject response=new JsonObject();
		Company company=new Company();
		
		
		company.setCompanyName(request.getCompanyName());
		company.setLocation(request.getLocation());
		
		List<Employee> emplist=new ArrayList<>();
		
		for(EmployeeRequest empReq:request.getEmployees()) {
			
			 if(employeeRepo.existsByEmail(empReq.getEmail())) {

			        response.addProperty("msg", "Email already exists");
			        response.addProperty("status", "FAILURE");

			        return response.toString();
			    }
			
			Employee emp=new Employee();
			emp.setEmployeeName(empReq.getEmployeeName());
			emp.setSalary(empReq.getSalary());
			emp.setEmail(empReq.getEmail());
			emp.setCompany(company);
			emplist.add(emp);
			
		}
		company.setEmployees(emplist);
		companyrepo.save(company);
		
	   response.addProperty("msg", "Company Saved");

        response.addProperty("status","SUCCESS");

        return response.toString();
}
	
	public String getAllComapany() {

	    List<Company> list = companyrepo.findAll();

	    JsonObject response = new JsonObject();

	    JsonArray dataarray = new JsonArray();

	    for(Company company : list) {

	        JsonObject data = new JsonObject();

	        data.addProperty("id", company.getId());
	        data.addProperty("companyName", company.getCompanyName());
	        data.addProperty("location", company.getLocation());

	        JsonArray empArray = new JsonArray();

	        for(Employee emp : company.getEmployees()) {

	            JsonObject empObj = new JsonObject();

	            empObj.addProperty("id", emp.getId());
	            empObj.addProperty("employeeName", emp.getEmployeeName());
	            empObj.addProperty("salary", emp.getSalary());
	            empObj.addProperty("email", emp.getEmail());

	            empArray.add(empObj);
	        }

	        data.add("employees", empArray);
	        dataarray.add(data);
	    }

	    response.add("data", dataarray);
	    response.addProperty("msg", "Companies fetched");
	    response.addProperty("status", "SUCCESS");
	    return response.toString();
	}
	
	@Override
	public String getCompanyId(int id) {

	    Optional<Company> opt = companyrepo.findById(id);
	    JsonObject response = new JsonObject();
	    if(opt.isPresent()) {

	        Company company = opt.get();

	        JsonObject data = new JsonObject();

	        data.addProperty("id", company.getId());
	        data.addProperty("companyName", company.getCompanyName());
	        data.addProperty("location", company.getLocation());

	        response.add("data", data);

	        response.addProperty("msg", "Company found");
	        response.addProperty("status", "SUCCESS");

	    } else {

	        response.addProperty("msg", "Company not found");
	        response.addProperty("status", "FAILURE");
	    }

	    return response.toString();
	}
     
	
	@Override
	public String getCompanyByName(String companyName) {

	    Optional<Company> opt = companyrepo.findByCompanyName(companyName);
	    JsonObject response = new JsonObject();

	    if(opt.isPresent()) {

	        Company company = opt.get();
	        JsonObject data = new JsonObject();

	        data.addProperty("id", company.getId());
	        data.addProperty("companyName", company.getCompanyName());
	        data.addProperty("location", company.getLocation());

	        JsonArray empArray = new JsonArray();

	        for(Employee emp : company.getEmployees()) {

	            JsonObject empObj = new JsonObject();

	            empObj.addProperty("id", emp.getId());
	            empObj.addProperty("employeeName", emp.getEmployeeName());
	            empObj.addProperty("salary", emp.getSalary());
	            empObj.addProperty("email", emp.getEmail());

	            empArray.add(empObj);
	        }

	        data.add("employees", empArray);
	        response.add("data", data);
	        response.addProperty("msg", "Company found");
	        response.addProperty("status", "SUCCESS");

	    } else {

	        response.addProperty("msg", "Company not found");
	        response.addProperty("status", "FAILURE");
	    }

	    return response.toString();
	}

	    @Override
	    public String deleteCompany(int id) {
    
	        JsonObject response =new JsonObject();
	        companyrepo.deleteById(id);
	        response.addProperty("msg", "Company deleted");
	        response.addProperty("status","SUCCESS");
	        return response.toString();
	    }
	

	

	

	
}
