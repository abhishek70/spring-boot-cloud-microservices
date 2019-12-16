package com.abhishekd.profileservice.client;

import com.abhishekd.profileservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "auth-service")
public interface AuthServiceClient {

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createUser(User user);
}
