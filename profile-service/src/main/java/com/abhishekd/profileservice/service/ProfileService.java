package com.abhishekd.profileservice.service;

import com.abhishekd.profileservice.model.Profile;
import com.abhishekd.profileservice.model.User;

/**
 * ProfileService interface
 */
public interface ProfileService {

    /**
     * Method for getting user details by username
     * @param username
     * @return
     */
    Profile findByUsername(String username);

    /**
     * Method for creating auth user
     * @param user
     * @return
     */
    Profile create(User user);
}
