package com.AppDevelopement.Dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.AppDevelopement.Dev.bean.*;
import com.AppDevelopement.Dev.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // ---------------- SIGNUP ----------------
    @PostMapping("/signup")
    public String signUp(@RequestBody SignUpRequest request) {
        return userService.signUp(request);
    }

    // ---------------- VERIFY OTP ----------------
    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestBody VerifyOtpRequest request) {
        return userService.verifyOtp(request);
    }

    // ---------------- LOGIN ----------------
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
    @PostMapping("/login-otp")
    public String sendLoginOtp(@RequestBody LoginOtpRequest request) {
        return userService.sendLoginOtp(request);
    }

    @PostMapping("/verify-login-otp")
    public String verifyLoginOtp(@RequestBody VerifyOtpRequest request) {
        return userService.verifyLoginOtp(request);
    }
    @GetMapping("/gretting")
    public String Hello() {
    	return"hello world";
    }
}