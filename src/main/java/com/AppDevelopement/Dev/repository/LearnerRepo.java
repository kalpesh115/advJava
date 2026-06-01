package com.AppDevelopement.Dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AppDevelopement.Dev.entity.Learner;

public interface LearnerRepo extends JpaRepository<Learner, Integer>{

}