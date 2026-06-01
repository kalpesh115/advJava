package com.AppDevelopement.Dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AppDevelopement.Dev.entity.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {

    Optional<Users> findByEmail(String email);

    Optional<Users> findByMobileNo(String mobileNo);
}

