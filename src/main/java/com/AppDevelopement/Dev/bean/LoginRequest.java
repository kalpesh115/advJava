package com.AppDevelopement.Dev.bean;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}