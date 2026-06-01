package com.AppDevelopement.Dev.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AppDevelopement.Dev.bean.CourseRequest;
import com.AppDevelopement.Dev.bean.LearnerRequest;
import com.AppDevelopement.Dev.entity.Course;
import com.AppDevelopement.Dev.entity.Learner;
import com.AppDevelopement.Dev.repository.LearnerRepo;
import com.AppDevelopement.Dev.service.LearnerService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service
public class LearnerServiceImpl implements LearnerService {

    @Autowired
    LearnerRepo learnerRepo;

    @Override
    public String saveLearner(LearnerRequest request) {

        JsonObject response = new JsonObject();

        Learner learner = new Learner();

        learner.setLearnerName(request.getLearnerName());
        learner.setCity(request.getCity());

        List<Course> courseList = new ArrayList<>();

        for (CourseRequest courseReq : request.getCourses()) {

            System.out.println("DEBUG courseName: " + courseReq.getCourseName());
            System.out.println("DEBUG fees: " + courseReq.getFees());

            Course course = new Course();

            course.setCourseName(courseReq.getCourseName());
            course.setFees(courseReq.getFees());
            course.setLearner(learner);   
           
            courseList.add(course);
        }

        learner.setCourses(courseList);

        learnerRepo.save(learner);

        response.addProperty("msg", "Learner Saved");
        response.addProperty("status", "SUCCESS");

        return response.toString();
    }
    @Override
    public String getAllLearner() {

        List<Learner> list = learnerRepo.findAll();

        JsonObject response = new JsonObject();

        JsonArray dataArray = new JsonArray();

        for(Learner learner : list) {

            JsonObject data = new JsonObject();

            data.addProperty("id", learner.getId());

            data.addProperty("learnerName", learner.getLearnerName());

            data.addProperty("city", learner.getCity());

            JsonArray courseArray = new JsonArray();

            for(Course course : learner.getCourses()) {

                JsonObject courseObj = new JsonObject();

                courseObj.addProperty("id", course.getId());

                courseObj.addProperty("courseName", course.getCourseName());

                courseObj.addProperty("fees", course.getFees());

                courseArray.add(courseObj);
            }

            data.add("courses", courseArray);

            dataArray.add(data);
        }

        response.add("data", dataArray);

        response.addProperty("msg", "Learners fetched");

        response.addProperty("status", "SUCCESS");

        return response.toString();
    }

    @Override
    public String getLearnerById(int id) {

        Optional<Learner> opt = learnerRepo.findById(id);

        JsonObject response = new JsonObject();

        if(opt.isPresent()) {

            Learner learner = opt.get();

            JsonObject data = new JsonObject();

            data.addProperty("id", learner.getId());

            data.addProperty("learnerName", learner.getLearnerName());

            data.addProperty("city", learner.getCity());

            JsonArray courseArray = new JsonArray();

            for(Course course : learner.getCourses()) {

                JsonObject courseObj = new JsonObject();

                courseObj.addProperty("id", course.getId());

                courseObj.addProperty("courseName", course.getCourseName());

                courseObj.addProperty("fees", course.getFees());

                courseArray.add(courseObj);
            }

            data.add("courses", courseArray);

            response.add("data", data);

            response.addProperty("msg", "Learner Found");

            response.addProperty("status", "SUCCESS");

        } else {

            response.addProperty("msg", "Learner Not Found");

            response.addProperty("status", "FAILURE");
        }

        return response.toString();
    }

    @Override
    public String deleteLearner(int id) {

        JsonObject response = new JsonObject();

        learnerRepo.deleteById(id);

        response.addProperty("msg", "Learner Deleted");

        response.addProperty("status", "SUCCESS");

        return response.toString();
    }
	@Override
	public String saveLearner(String request) {
		// TODO Auto-generated method stub
		return null;
	}
}