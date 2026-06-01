package com.AppDevelopement.Dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.AppDevelopement.Dev.bean.StudentRequest;
import com.AppDevelopement.Dev.service.CrudService;

@RestController
@RequestMapping(value="/api/students", produces="application/json")
public class CrudController {

    @Autowired
    CrudService crudeservice;

    @PostMapping(value="/create", produces="application/json")
    public String saveStudent(@RequestBody StudentRequest request) {

        return crudeservice.saveRecord(request);
    }

    @GetMapping(value="/get-all", produces="application/json")
    public String getAllStudents() {

        return crudeservice.getAllStudents();
    }

    @GetMapping(value="/get-by-id/{id}", produces="application/json")
    public String getStudentById(@PathVariable int id) {

        return crudeservice.getById(id);
    }

    @GetMapping(value="/get-by-name/{name}", produces="application/json")
    public String getStudentByName(@PathVariable String name) {

        return crudeservice.getByName(name);
    }

   
    @PutMapping(value="/update/{id}", produces="application/json")
    public String updateStudent(@PathVariable int id,
                                @RequestBody StudentRequest request) {

        return crudeservice.updateStudentInfo(id, request);
    }

  
    @DeleteMapping(value="/delete/{id}", produces="application/json")
    public String deleteStudent(@PathVariable int id) {

        return crudeservice.deleteById(id);
    }
}