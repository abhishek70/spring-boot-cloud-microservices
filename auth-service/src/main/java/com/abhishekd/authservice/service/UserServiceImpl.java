package com.abhishekd.authservice.service;

import com.abhishekd.authservice.exception.ResourceExistsException;
import com.abhishekd.authservice.model.User;
import com.abhishekd.authservice.repository.UserDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * UserServiceImpl class
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    // Password Encoder
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * Method implementation for creating user
     * @param authUserDetail
     */
    @Override
    public void create(User authUserDetail) {

        // Attempt to fetch user from database from provided username
        Optional<User> user = userDetailRepository.findByUsername(authUserDetail.getUsername());

        user.ifPresent(isUser->{throw new ResourceExistsException(isUser.getUsername());});

        String passwordHash = encoder.encode(authUserDetail.getPassword());
        authUserDetail.setPassword(passwordHash);

        // Saving user in db
        userDetailRepository.save(authUserDetail);

        log.info("Created new user: {}", authUserDetail.getUsername());
    }
}
