package com.example.demo.controller;

import com.example.demo.model.StudentModel;
import com.example.demo.repository.StudentRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    StudentRepository repo;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("student", new StudentModel());
        model.addAttribute("students", repo.findAll());
        return "students";
    }

    @PostMapping("/save")
    public String save(StudentModel student) {
        repo.save(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        repo.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        StudentModel student =
                repo.findById(id).orElse(null);

        model.addAttribute("student", student);
        model.addAttribute("students", repo.findAll());

        return "students";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword,
                         Model model) {

        List<StudentModel> students =
                repo.findByNameContaining(keyword);

        model.addAttribute("student", new StudentModel());
        model.addAttribute("students", students);

        return "students";
    }
}