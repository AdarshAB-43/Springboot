package com.example.demo.controller;

import com.example.demo.model.JobSeeker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JobController {

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("jobSeeker", new JobSeeker());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute JobSeeker jobSeeker,
                           Model model) {

        model.addAttribute("name", jobSeeker.getFullName());
        return "success";
    }
}