package com.company.books.controller;

import com.company.books.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/api/books")
    public List<Book> getBooks() {
        return books;
    }
}
