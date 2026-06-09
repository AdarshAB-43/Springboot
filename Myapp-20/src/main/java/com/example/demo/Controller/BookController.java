package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Service.BookService;
import com.example.demo.entity.Book;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public Object getBookById(@PathVariable Long id) {

        Book book = service.getBookById(id);

        if(book == null) {
            Map<String,String> error = new HashMap<>();
            error.put("message", "Book not found with id : " + id);
            return error;
        }

        return book;
    }

    @PutMapping("/{id}")
    public Object updateBook(@PathVariable Long id,
                             @RequestBody Book book) {

        Book updated = service.updateBook(id, book);

        if(updated == null) {
            Map<String,String> error = new HashMap<>();
            error.put("message", "Book not found with id : " + id);
            return error;
        }

        return updated;
    }

    @DeleteMapping("/{id}")
    public Map<String,String> deleteBook(@PathVariable Long id) {

        Map<String,String> response = new HashMap<>();

        if(service.deleteBook(id)) {
            response.put("message", "Book deleted successfully");
        } else {
            response.put("message", "Book not found with id : " + id);
        }

        return response;
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String keyword) {
        return service.searchBooks(keyword);
    }
}