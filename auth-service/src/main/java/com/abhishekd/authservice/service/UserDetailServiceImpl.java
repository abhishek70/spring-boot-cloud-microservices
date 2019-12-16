package com.abhishekd.authservice.service;

import com.abhishekd.authservice.model.AuthUserDetail;
import com.abhishekd.authservice.model.User;
import com.abhishekd.authservice.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * UserDetailServiceImpl class
 */
@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Attempt to fetch user from database from provided username
        Optional<User> user = userDetailRepository.findByUsername(username);

        // Throw an exception if the user is not found and
        // send a generic message
        // TODO
        // 1. Load generic message from properties file
        user.orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));

        // Getting user detail
        UserDetails userDetail = new AuthUserDetail(user.get());

        // Validating the user details
        new AccountStatusUserDetailsChecker().check(userDetail);

        // User detail response
        return userDetail;
    }
}
