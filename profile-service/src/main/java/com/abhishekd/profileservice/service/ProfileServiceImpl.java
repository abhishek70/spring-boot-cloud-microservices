package com.abhishekd.profileservice.service;

import com.abhishekd.profileservice.client.AuthServiceClient;
import com.abhishekd.profileservice.exception.ResourceNotFoundException;
import com.abhishekd.profileservice.model.Profile;
import com.abhishekd.profileservice.model.User;
import com.abhishekd.profileservice.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProfileServiceImpl class
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AuthServiceClient authClient;

    /**
     * Method for getting user details by username
     * @param username
     * @return
     */
    @Override
    public Profile findByUsername(String username) {

        // Getting user profile by provided by username
        Profile profile = profileRepository.findByUsername(username);

        // if profile not found throw an exception
        if(profile == null)
           throw new ResourceNotFoundException("User with "+ username+" not found");

        return profile;
    }

    /**
     * Method for creating auth user
     * @param user
     * @return
     */
    @Override
    public Profile create(User user) {

        // Calling AuthClient to create auth user
        authClient.createUser(user);

        // Creating user profile
        Profile profile = new Profile();
        profile.setUsername(user.getUsername());
        return profile;
    }
}
