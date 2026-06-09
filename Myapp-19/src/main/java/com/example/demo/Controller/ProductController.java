package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Service.ProductService;
import com.example.demo.entity.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Object getProductById(@PathVariable Long id) {

        Product product = service.getProductById(id);

        if(product == null) {

            Map<String,String> error = new HashMap<>();

            error.put("message",
                    "Product not found with id : " + id);

            return error;
        }

        return product;
    }

    @PutMapping("/{id}")
    public Object updateProduct(@PathVariable Long id,
                                @RequestBody Product product) {

        Product updated = service.updateProduct(id, product);

        if(updated == null) {

            Map<String,String> error = new HashMap<>();

            error.put("message",
                    "Product not found with id : " + id);

            return error;
        }

        return updated;
    }

    @DeleteMapping("/{id}")
    public Map<String,String> deleteProduct(@PathVariable Long id) {

        Map<String,String> response = new HashMap<>();

        if(service.deleteProduct(id)) {
            response.put("message",
                    "Product deleted successfully");
        }
        else {
            response.put("message",
                    "Product not found with id : " + id);
        }

        return response;
    }

    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam String keyword) {

        return service.searchProducts(keyword);
    }
}