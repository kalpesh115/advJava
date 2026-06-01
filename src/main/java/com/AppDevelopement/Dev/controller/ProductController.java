
package com.AppDevelopement.Dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.AppDevelopement.Dev.bean.ProductRequest;
import com.AppDevelopement.Dev.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/saveProduct")
    public String saveProduct(@RequestBody ProductRequest request) {

        return productService.saveProduct(request);
    }

    @GetMapping("/getAllProduct")
    public String getAllProduct() {

        return productService.getAllProduct();
    }

    @GetMapping("/getSingleProduct/{productId}")
    public String getSingleProduct(@PathVariable int productId) {

        return productService.getSingleProduct(productId);
    }

    @PutMapping("/updateProduct/{productId}")
    public String updateProduct(@PathVariable int productId,
                                @RequestBody ProductRequest request) {

        return productService.updateProduct(productId,request);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable int productId) {

        return productService.deleteProduct(productId);
    }
}