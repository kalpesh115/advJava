package com.AppDevelopement.Dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppDevelopement.Dev.service.AppServiceResTem;

@RestController
public class RetsTempleteController {

    @Autowired
    private AppServiceResTem appservicerestem;

    
    
    @GetMapping(value="/products/id-price", produces="application/json")
    public String getIdAndPrice() {
        return appservicerestem.getIdAndPrice();
    }
}
