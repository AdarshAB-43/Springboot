package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/books")
    public String books(Model model) {

        model.addAttribute("title", "The Alchemist");
        model.addAttribute("author", "Paulo Coelho");
        model.addAttribute("price", "₹499");

        return "books";
    }
}