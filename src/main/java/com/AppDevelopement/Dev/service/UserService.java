package com.AppDevelopement.Dev.service;

import com.AppDevelopement.Dev.bean.*;

public interface UserService {

    String signUp(SignUpRequest request);

    String verifyOtp(VerifyOtpRequest request);

    String login(LoginRequest request);
    String sendLoginOtp(LoginOtpRequest request);

    String verifyLoginOtp(VerifyOtpRequest request);
}