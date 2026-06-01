package com.AppDevelopement.Dev.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String mobileNo;
    private String password;

    private int otp;
    private boolean otpUsed;
    private boolean verified;

    private LocalDateTime otpExpireTime;
}