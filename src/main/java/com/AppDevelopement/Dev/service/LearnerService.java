package com.AppDevelopement.Dev.service;

import com.AppDevelopement.Dev.bean.LearnerRequest;

public interface LearnerService {

    String saveLearner(String request);

    String getAllLearner();

    String getLearnerById(int id);

    String deleteLearner(int id);

	String saveLearner(LearnerRequest request);
}