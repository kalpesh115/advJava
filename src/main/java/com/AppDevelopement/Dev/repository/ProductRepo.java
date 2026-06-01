
package com.AppDevelopement.Dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AppDevelopement.Dev.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}