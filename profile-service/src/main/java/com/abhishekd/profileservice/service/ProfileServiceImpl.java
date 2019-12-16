package com.abhishekd.profileservice.service;

import com.abhishekd.profileservice.client.AuthServiceClient;
import com.abhishekd.profileservice.exception.ResourceNotFoundException;
import com.abhishekd.profileservice.model.Profile;
import com.abhishekd.profileservice.model.User;
import com.abhishekd.profileservice.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AuthServiceClient authClient;

    @Override
    public Profile findByUsername(String username) {
       Profile profile = profileRepository.findByUsername(username);

       if(profile == null)
           throw new ResourceNotFoundException("User with "+ username+" not found");

       return profile;
    }

    @Override
    public Profile create(User user) {

        authClient.createUser(user);

        Profile profile = new Profile();
        profile.setUsername(user.getUsername());

        return profile;
    }
}
