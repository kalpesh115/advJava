
package com.AppDevelopement.Dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.AppDevelopement.Dev.bean.OrderRequest;
import com.AppDevelopement.Dev.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody OrderRequest request) {

        return orderService.placeOrder(request);
    }
}