
package com.AppDevelopement.Dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AppDevelopement.Dev.entity.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer>{

}