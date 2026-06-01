package com.AppDevelopement.Dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @Bean(name = "restTemplateTwo")
    public RestTemplate restTemplateTwo() {
        return new RestTemplate();
    }
}