package com.AppDevelopement.Dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.AppDevelopement.Dev.service.LearnerService;

@RestController
@RequestMapping("/learner")
public class LearnerController {

    @Autowired
    LearnerService learnerService;

    @PostMapping("/create")
    public String saveLearner(@RequestBody String request){

        return learnerService.saveLearner(request);
    }

    @GetMapping("/getAll")
    public String getAllLearner(){

        return learnerService.getAllLearner();
    }

    @GetMapping("/getById/{id}")
    public String getLearnerById(@PathVariable int id){

        return learnerService.getLearnerById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteLearner(@PathVariable int id){

        return learnerService.deleteLearner(id);
    }
}