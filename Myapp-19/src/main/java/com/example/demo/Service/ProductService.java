package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product product) {

        Product existing = repository.findById(id).orElse(null);

        if(existing != null) {
            existing.setName(product.getName());
            existing.setDescription(product.getDescription());
            existing.setPrice(product.getPrice());
            existing.setExpirydate(product.getExpirydate());
            existing.setCategory(product.getCategory());
            existing.setStock(product.getStock());

            return repository.save(existing);
        }

        return null;
    }

    public boolean deleteProduct(Long id) {

        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

    public List<Product> searchProducts(String keyword) {
        return repository.findByNameContainingIgnoreCase(keyword);
    }
}