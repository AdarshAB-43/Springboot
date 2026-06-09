package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User login(String email, String password) {

        User user = userRepository.findByEmail(email);

        if(user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}