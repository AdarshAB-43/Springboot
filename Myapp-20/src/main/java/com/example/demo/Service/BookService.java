package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.BookRepository;
import com.example.demo.entity.Book;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Book updateBook(Long id, Book book) {

        Book existing = repository.findById(id).orElse(null);

        if(existing != null) {

            existing.setTitle(book.getTitle());
            existing.setAuthor(book.getAuthor());
            existing.setGenre(book.getGenre());
            existing.setPrice(book.getPrice());
            existing.setPublishedDate(book.getPublishedDate());

            return repository.save(existing);
        }

        return null;
    }

    public boolean deleteBook(Long id) {

        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

    public List<Book> searchBooks(String keyword) {
        return repository.findByTitleContainingIgnoreCase(keyword);
    }
}