package com.AppDevelopement.Dev.serviceImpl;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AppDevelopement.Dev.bean.*;
import com.AppDevelopement.Dev.entity.Users;
import com.AppDevelopement.Dev.exception.UserNotFoundCustomException;
import com.AppDevelopement.Dev.repository.UserRepo;
import com.AppDevelopement.Dev.service.TwilioService;
import com.AppDevelopement.Dev.service.UserService;
import com.google.gson.JsonObject;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TwilioService twilioService;

    // SIGNUP
    @Override
    public String signUp(SignUpRequest request) {

        JsonObject obj = new JsonObject();
        if(userRepo.findByMobileNo(request.getMobileNo()).isPresent()) {

            obj.addProperty("msg", "Mobile number already registered");
            obj.addProperty("status", "FAILED");

            return obj.toString();
        }
        if(userRepo.findByEmail(request.getEmail()).isPresent()) {

            obj.addProperty("msg", "Email already registered");
            obj.addProperty("status", "FAILED");

            return obj.toString();
        }


        Users user = new Users();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setMobileNo(request.getMobileNo());
        user.setPassword(request.getPassword());

        int otp = 1000 + new Random().nextInt(9000);

        user.setOtp(otp);
        user.setOtpUsed(false);
        user.setVerified(false);
        user.setOtpExpireTime(LocalDateTime.now().plusMinutes(5));

        userRepo.save(user);

        // SEND OTP VIA TWILIO
        twilioService.sendOtp(user.getMobileNo(), String.valueOf(otp));

        obj.addProperty("msg", "OTP sent successfully");
        obj.addProperty("status", "SUCCESS");

        return obj.toString();
    }

 // VERIFY OTP
    @Override
    public String verifyOtp(VerifyOtpRequest request) {

        JsonObject obj = new JsonObject();

        Users user = userRepo.findByMobileNo(request.getMobileNo())
                .orElseThrow(() -> new UserNotFoundCustomException("User not found"));

        if (user.isOtpUsed()) {
            obj.addProperty("msg", "OTP already used");
            return obj.toString();
        }

        if (LocalDateTime.now().isAfter(user.getOtpExpireTime())) {
            obj.addProperty("msg", "OTP expired");
            return obj.toString();
        }

        if (user.getOtp() != request.getOtp()) {
            obj.addProperty("msg", "Invalid OTP");
            return obj.toString();
        }

        user.setVerified(true);
        user.setOtpUsed(true);

        userRepo.save(user);

        obj.addProperty("msg", "OTP verified successfully");

        return obj.toString();
    }
    @Override
    public String verifyLoginOtp(VerifyOtpRequest request) {

        JsonObject obj = new JsonObject();

        Users user = userRepo.findByMobileNo(request.getMobileNo())
                .orElseThrow(() ->
                        new UserNotFoundCustomException("User not found"));

        if(user.isOtpUsed()) {

            obj.addProperty("msg", "OTP already used");

            return obj.toString();
        }

        if(LocalDateTime.now().isAfter(user.getOtpExpireTime())) {

            obj.addProperty("msg", "OTP expired");

            return obj.toString();
        }

        if(user.getOtp() != request.getOtp()) {

            obj.addProperty("msg", "Invalid OTP");

            return obj.toString();
        }

        user.setOtpUsed(true);

        userRepo.save(user);

        obj.addProperty("msg", "Login successful");

        return obj.toString();
    }

    // LOGIN
    @Override
    public String login(LoginRequest request) {

        JsonObject obj = new JsonObject();

        Users user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserNotFoundCustomException("User not found"));

        if (!user.isVerified()) {
            obj.addProperty("msg", "Please verify OTP first");
            return obj.toString();
        }

        if (!user.getPassword().equals(request.getPassword())) {
            obj.addProperty("msg", "Invalid password");
            return obj.toString();
        }

        obj.addProperty("msg", "Login successful");
        return obj.toString();
    }
    @Override
    public String sendLoginOtp(LoginOtpRequest request) {

        JsonObject obj = new JsonObject();

        Users user = userRepo.findByMobileNo(request.getMobileNo())
                .orElseThrow(() ->
                        new UserNotFoundCustomException("User not found"));

        int otp = 1000 + new Random().nextInt(9000);

        user.setOtp(otp);

        user.setOtpUsed(false);

        user.setOtpExpireTime(LocalDateTime.now().plusMinutes(5));

        userRepo.save(user);

        twilioService.sendOtp(user.getMobileNo(), String.valueOf(otp));

        obj.addProperty("msg", "Login OTP sent");

        return obj.toString();
    }

	
}