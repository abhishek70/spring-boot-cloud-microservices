package com.abhishekd.profileservice.client;

import com.abhishekd.profileservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * AuthServiceClient class
 */
@FeignClient(name = "auth-service")
public interface AuthServiceClient {

    /**
     * Method for creating auth user
     * @param user
     */
    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createUser(User user);
}
