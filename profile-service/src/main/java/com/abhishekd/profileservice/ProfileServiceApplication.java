package com.abhishekd.profileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableOAuth2Client
@EnableFeignClients
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ProfileServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfileServiceApplication.class, args);
    }
}
