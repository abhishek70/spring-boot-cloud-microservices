package com.abhishekd.authservice.service;

import com.abhishekd.authservice.model.User;

/**
 * UserService class
 */
public interface UserService {

    /**
     * Create user
     * @param user
     */
    void create(User user);
}
