package com.abhishekd.profileservice.repository;

import com.abhishekd.profileservice.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProfileRepository class
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    Profile findByUsername(String username);
}
