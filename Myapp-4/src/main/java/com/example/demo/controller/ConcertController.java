package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConcertController {

    @GetMapping("/concert")
    public String concertPage() {
        return "concert";
    }

}