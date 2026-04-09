package com.company.books.controller;

import com.company.books.entity.Book;
import com.company.books.request.BookRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final List<Book> books = new ArrayList<>();

    public BooksController() {
        initializeBooks();
    }

    private void initializeBooks() {
        books.addAll(List.of(
        new Book(1, "Computer Science Pro", "Hasim Shah", "Computer Science", 5),
                new Book(2, "Java Spring Master", "Basim Shah", "Computer Science", 5),
                new Book(3, "Why 1+1 Rocks", "Hasin Shah", "Math", 5),
                new Book(4, "How Bears Hibernate", "Dara Shah", "Science", 2),
                new Book(5, "A Pirate's Treasure", "Aabis Alvi", "History", 3),
                new Book(6, "Why 2+2 is Better", "Basil Alvi", "Math", 1)
        ));
    }
//
//    @GetMapping("/api/books")
//    public List<Book> getBooks() {
//        return books;
//    }

    @GetMapping("/{id}")
    public Book getBookByTitle(@PathVariable long id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @GetMapping
    public List<Book> getBooks(@RequestParam(required = false) String category) {
        if (category == null) {
            return books;
        }
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    @PostMapping
    public void createBook(@RequestBody BookRequest bookRequest) {

        long id = books.isEmpty() ? 1 : books.get(books.size() - 1).getId() + 1;

        Book book = new Book(id, bookRequest.getTitle(), bookRequest.getAuthor(), bookRequest.getCategory(), bookRequest.getRating());

        books.add(book);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable long id, @RequestBody Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.set(i, updatedBook);
                return;
            }
        }
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        books.removeIf(book -> book.getId() == id);
    }
}
