package com.company.books.controller;

import com.company.books.entity.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksController {

    private final List<Book> books = new ArrayList<>();

    public BooksController() {
        initializeBooks();
    }

    private void initializeBooks() {
        books.addAll(List.of(
        new Book("Title One", "Author One", "science"),
        new Book("Title Two", "Author Two", "history"),
        new Book("Title Three", "Author Three", "math"),
        new Book("Title Four", "Author Four", "ethics"),
        new Book("Title Five", "Author Five", "religion"),
        new Book("Title Six", "Author Six", "philosophy"),
        new Book("Title Seven", "Author Seven", "politics")
        ));
    }
//
//    @GetMapping("/api/books")
//    public List<Book> getBooks() {
//        return books;
//    }

    @GetMapping("/api/books/{title}")
    public Book getBookByTitle(@PathVariable String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String category) {
        if (category == null) {
            return books;
        }
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    @PostMapping("/api/books")
    public void createBook(@RequestBody Book newBook) {
        boolean isNewBook = books
                .stream()
                .noneMatch(book -> book.getTitle().equalsIgnoreCase(newBook.getTitle()));
        if (isNewBook) {
            books.add(newBook);
        }
    }
}
