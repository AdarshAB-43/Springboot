package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage(Model model) {

        String welcomeMessage = "Learning never exhausts the mind.";
        String headingMessage = "<h1>Hello from Spring Boot!</h1>";

        boolean isLoggedIn = true;

        model.addAttribute("welcome", welcomeMessage);
        model.addAttribute("heading", headingMessage);
        model.addAttribute("loginStatus", isLoggedIn);

        return "home";
    }
}