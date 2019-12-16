package com.abhishekd.authservice.controller;

import com.abhishekd.authservice.model.AuthUserDetail;
import com.abhishekd.authservice.model.User;
import com.abhishekd.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/current")
    public Principal getUser(Principal principal) {
        return principal;
    }

    @PostMapping
    public void create(@Valid @RequestBody User user)
    {
        userService.create(user);
    }
}
