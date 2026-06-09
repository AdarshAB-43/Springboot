package com.example.demo.DashboardController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        Object user = session.getAttribute("loggedUser");

        if(user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);

        return "dashboard";
    }
}