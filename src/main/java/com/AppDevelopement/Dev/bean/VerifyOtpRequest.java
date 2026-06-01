package com.AppDevelopement.Dev.bean;

import lombok.Data;

@Data
public class VerifyOtpRequest {
    private String mobileNo;
    private int otp;
}