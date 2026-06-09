package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Service.UserService;
import com.example.demo.entity.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String register(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session) {

        User user = userService.login(email, password);

        if(user != null) {
            session.setAttribute("user", user);
            return "redirect:/welcome";
        }

        return "redirect:/";
    }

    @GetMapping("/welcome")
    public String welcome(HttpSession session) {

        if(session.getAttribute("user") == null) {
            return "redirect:/";
        }

        return "welcome";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/";
    }
}