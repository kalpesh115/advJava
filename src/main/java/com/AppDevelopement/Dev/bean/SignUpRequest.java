package com.AppDevelopement.Dev.bean;

import lombok.Data;

@Data
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;
    private String password;
}