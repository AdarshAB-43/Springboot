package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.DTO.RegisterRequest;
import com.example.demo.DTO.RegisterResponse;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public RegisterResponse registerUser(
            @RequestBody RegisterRequest request) {

        return userService.registerUser(request);
    }
}