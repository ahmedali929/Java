package com.company.books.controller;

import com.company.books.entity.Book;
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

    @GetMapping("/{title}")
    public Book getBookByTitle(@PathVariable String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
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
    public void createBook(@RequestBody Book newBook) {
        boolean isNewBook = books
                .stream()
                .noneMatch(book -> book.getTitle().equalsIgnoreCase(newBook.getTitle()));
        if (isNewBook) {
            books.add(newBook);
        }
    }

    @PutMapping("/{title}")
    public void updateBook(@PathVariable String title, @RequestBody Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.set(i, updatedBook);
                return;
            }
        }
    }

    @DeleteMapping("/{title}")
    public void deleteBook(@PathVariable String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }
}
