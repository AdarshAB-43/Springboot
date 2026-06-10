package com.example.demo.DTO;

public class RegisterResponse {

    private String username;
    private String email;

    public RegisterResponse(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}