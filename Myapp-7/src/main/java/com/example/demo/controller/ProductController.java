package com.example.demo.controller;

import com.example.demo.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/single-product")
    public String singleProduct(Model model) {

        Product product = new Product(101, "Sugar", 55.5);

        model.addAttribute("product", product);

        return "single-product";
    }

    @GetMapping("/product-list")
    public String productList(Model model) {

        List<Product> products = new ArrayList<>();

        products.add(new Product(101, "Sugar", 55.5));
        products.add(new Product(102, "Salt", 20.0));
        products.add(new Product(103, "Wheat Flour", 38.75));

        model.addAttribute("products", products);

        return "product-list";
    }
}