package com.AppDevelopement.Dev.serviceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List; 
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.AppDevelopement.Dev.bean.StudentRequest;
import com.AppDevelopement.Dev.entity.Address;
import com.AppDevelopement.Dev.entity.StudentInfo; 
import com.AppDevelopement.Dev.repository.StudentRepo; 
import com.AppDevelopement.Dev.service.CrudService; 
import com.google.gson.JsonObject;

import lombok.Data;

import com.google.gson.JsonArray;

@Service
public class CrudServiceImpl implements CrudService {

    @Autowired
    StudentRepo repo;

  
    public String saveRecord(StudentRequest request) {

        JsonObject response = new JsonObject();

        Address add = new Address();

        add.setCity(request.getAddress().getCity());
        add.setState(request.getAddress().getState());
        add.setLandmark(request.getAddress().getLandmark());
        add.setStreet1(request.getAddress().getStreet1());
        add.setStreet2(request.getAddress().getStreet2());
        add.setPincode(request.getAddress().getPincode());

        StudentInfo info = new StudentInfo();

        info.setName(request.getName());
        info.setAge(request.getAge());
        info.setEmail(request.getEmail());

        info.setAddress(add);

        repo.save(info);



        JsonObject data = new JsonObject();

        data.addProperty("id", info.getId());

        data.addProperty("name", info.getName());

        data.addProperty("age", info.getAge());

        data.addProperty("email", info.getEmail());



        JsonObject address = new JsonObject();

        address.addProperty("city", add.getCity());

        address.addProperty("state", add.getState());

        address.addProperty("street1", add.getStreet1());

        address.addProperty("street2", add.getStreet2());

        address.addProperty("landmark", add.getLandmark());

        address.addProperty("pincode", add.getPincode());



        data.add("address", address);

        response.add("data", data);

        response.addProperty("msg",
                "Record Created Successfully");

        response.addProperty("status",
                "SUCCESS");

        return response.toString();
    }
    public String getById(int id) {

        Optional<StudentInfo> stud = repo.findById(id);
        JsonObject response = new JsonObject();
        JsonObject data = new JsonObject();
        if(stud.isPresent()) {
            StudentInfo stud1 = stud.get();
            data.addProperty("id", stud1.getId());
            data.addProperty("name", stud1.getName());
            data.addProperty("age", stud1.getAge());
            data.addProperty("email", stud1.getEmail());
            JsonObject address = new JsonObject();
            address.addProperty("city",stud1.getAddress().getCity());

            address.addProperty("state",stud1.getAddress().getState());

            address.addProperty("street1",stud1.getAddress().getStreet1());

            address.addProperty("street2", stud1.getAddress().getStreet2());

            address.addProperty("landmark",stud1.getAddress().getLandmark());

            address.addProperty("pincode", stud1.getAddress().getPincode());



            data.add("address", address);

            response.add("data", data);

            response.addProperty("msg",
                    "Student fetched successfully");

            response.addProperty("status",
                    "SUCCESS");

        } else {

            response.addProperty("msg","Student not found");

            response.addProperty("status","FAILURE");
        }

        return response.toString();
    }
    @Override
    public String getByName(String name) {

        Optional<StudentInfo> list = repo.findByName(name);

        JsonObject response = new JsonObject();

        if (!list.isEmpty()) {
            response.addProperty("msg", "Student(s) found");
            response.addProperty("status", "SUCCESS");
        } else {
            response.addProperty("msg", "Student not found");
            response.addProperty("status", "FAILURE");
        }

        return response.toString();
    }

   
  
    public String updateStudentInfo(int id, StudentRequest request) {

        Optional<StudentInfo> opt =  repo.findById(id);

        JsonObject response =new JsonObject();

        if (!opt.isPresent()) {

            response.addProperty("msg","Student not found");

            response.addProperty("status","FAILURE");

            return response.toString();
        }
        StudentInfo stud = opt.get();
        stud.setName(request.getName());
        stud.setAge(request.getAge());
        stud.setEmail(request.getEmail());
        Address add = stud.getAddress();
        add.setCity(request.getAddress().getCity());
        add.setState(request.getAddress().getState());
        add.setStreet1(request.getAddress().getStreet1());
        add.setStreet2(request.getAddress().getStreet2());
        add.setLandmark(request.getAddress().getLandmark());
        add.setPincode(request.getAddress().getPincode());

        stud.setAddress(add);
        repo.save(stud);
        response.addProperty("msg","Student Updated Successfully");
        response.addProperty("status", "SUCCESS");

        return response.toString();
    }

  
    
    @Override
    public String getAllStudents() {

        List<StudentInfo> list = repo.findAll();

        JsonObject response = new JsonObject();
        JsonArray dataArray = new JsonArray();

        for(int i=0; i<list.size(); i++) {

            StudentInfo stud = list.get(i);

            JsonObject data = new JsonObject();

            data.addProperty("id", stud.getId());
            data.addProperty("name", stud.getName());
            data.addProperty("age", stud.getAge());
            data.addProperty("email", stud.getEmail());

            JsonObject address = new JsonObject();

            address.addProperty("city", stud.getAddress().getCity());
            address.addProperty("state", stud.getAddress().getState());
            address.addProperty("street1", stud.getAddress().getStreet1());
            address.addProperty("street2", stud.getAddress().getStreet2());
            address.addProperty("landmark", stud.getAddress().getLandmark());
            address.addProperty("pincode", stud.getAddress().getPincode());

            data.add("address", address);

            dataArray.add(data);
        }

        response.add("data", dataArray);
        response.addProperty("msg", "Students fetched successfully");
        response.addProperty("status", "SUCCESS");

        return response.toString();
    }
  
	
    
    public String deleteById(int id) {

        JsonObject response = new JsonObject();

        Optional<StudentInfo> opt = repo.findById(id);

        if (!opt.isPresent()) {

            response.addProperty("msg", "Student not found");
            response.addProperty("status", "FAILURE");

            return response.toString();
        }

        repo.deleteById(id);

        response.addProperty("msg", "Student deleted successfully");
        response.addProperty("status", "SUCCESS");

        return response.toString();
    }
	@Override
	public String getByName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getAllUsers(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String DeleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
    

	 
    
}






