package com.example.demo.controller;

import com.example.demo.model.LibraryMember;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LibraryController {

    @GetMapping("/library")
    public String showForm(Model model) {
        model.addAttribute("member", new LibraryMember());
        return "library";
    }

    @PostMapping("/library")
    public String register(@ModelAttribute LibraryMember member,
                           Model model) {

        model.addAttribute("name", member.getName());
        return "library-success";
    }
}