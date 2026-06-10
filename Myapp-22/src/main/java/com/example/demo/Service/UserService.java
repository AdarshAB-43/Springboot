package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.RegisterRequest;
import com.example.demo.DTO.RegisterResponse;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public RegisterResponse registerUser(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setMobileNumber(request.getMobileNumber());
        user.setEmail(request.getEmail());

        // Encode Password
        user.setPassword(
                passwordEncoder.encode(request.getPassword()));

        User savedUser = userRepository.save(user);

        String username =
                savedUser.getFirstName() + " " +
                savedUser.getLastName();

        return new RegisterResponse(
                username,
                savedUser.getEmail()
        );
    }
}