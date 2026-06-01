package com.AppDevelopement.Dev.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.AppDevelopement.Dev.service.TwilioService;

@Service
public class TwilioServiceImpl implements TwilioService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${twilio.account-sid}")
    private String ACCOUNT_SID;

    @Value("${twilio.auth-token}")
    private String AUTH_TOKEN;

    @Value("${twilio.from-number}")
    private String FROM_NUMBER;

    @Override
    public String sendOtp(String mobileNo, String otp) {

        String url = "https://api.twilio.com/2010-04-01/Accounts/"
                + ACCOUNT_SID + "/Messages.json";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(ACCOUNT_SID, AUTH_TOKEN);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("To", "+91" + mobileNo);
        body.add("From", FROM_NUMBER);
        body.add("Body", "Your OTP is: " + otp);

        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<>(body, headers);

        return restTemplate.postForObject(url, request, String.class);
    }
}