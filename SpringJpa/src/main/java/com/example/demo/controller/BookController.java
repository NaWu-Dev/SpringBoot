package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepo bookRepo;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @GetMapping("/books/{status}")
    public List<Book> getAllBooksWithStatus(@PathVariable String status) {
        return bookRepo.findAllWithStatusAndPublishedInYear(status);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        book.setPublishDate(new Date());
        book.setStatus("Init");
        bookRepo.save(book);
        return book;
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book newBook) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new BookNotFound(id));

        book.setName(newBook.getName());
        book.setStatus("Updated");
        book.setPublishDate(newBook.getPublishDate());
        bookRepo.save(book);
        return book;
    }

    private class BookNotFound extends RuntimeException {
        public BookNotFound(int id) {
            super("Could not find Book" + id);
        }
    }
}
