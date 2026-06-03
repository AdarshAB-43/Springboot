package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.PhoneModel;
import com.example.demo.repository.PhoneRepository;

@Controller
public class PhoneController {

    @Autowired
    PhoneRepository repo;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("phone",
                new PhoneModel());

        model.addAttribute("phones",
                repo.findAll());

        return "phones";
    }

    @PostMapping("/save")
    public String save(PhoneModel phone) {

        repo.save(phone);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable Integer id) {

        repo.deleteById(id);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable Integer id,
            Model model) {

        PhoneModel phone =
                repo.findById(id).orElse(null);

        model.addAttribute("phone", phone);
        model.addAttribute("phones",
                repo.findAll());

        return "phones";
    }
}