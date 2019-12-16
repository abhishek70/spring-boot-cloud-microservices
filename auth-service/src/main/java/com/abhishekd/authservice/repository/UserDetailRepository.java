package com.abhishekd.authservice.repository;

import com.abhishekd.authservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * UserDetailRepository class
 */
public interface UserDetailRepository extends JpaRepository<User, Integer> {

    // fetch user by provided username
    Optional<User> findByUsername(String username);
}
