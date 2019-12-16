package com.abhishekd.profileservice.controller;

import com.abhishekd.profileservice.model.Profile;
import com.abhishekd.profileservice.model.User;
import com.abhishekd.profileservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping(path = "/current")
    public ResponseEntity<Profile> getCurrentAccount(Principal principal) {
        Profile profile = profileService.findByUsername(principal.getName());
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Profile> create(@Valid @RequestBody User user)
    {
        Profile profile = profileService.create(user);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }

}
