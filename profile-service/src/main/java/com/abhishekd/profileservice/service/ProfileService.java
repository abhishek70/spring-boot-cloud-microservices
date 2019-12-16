package com.abhishekd.profileservice.service;

import com.abhishekd.profileservice.model.Profile;
import com.abhishekd.profileservice.model.User;

public interface ProfileService {

    Profile findByUsername(String username);

    Profile create(User user);
}
