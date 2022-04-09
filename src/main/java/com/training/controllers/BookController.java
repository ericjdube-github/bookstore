package com.training.controllers;

import com.training.model.Book;
import com.training.services.BookServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ericjdube on 4/8/2022 5:06 PM
 */
@RequestMapping("/bookstore/api") // localhost:8081/bookstore/api
@RestController
public class BookController {

    @Autowired
    private BookServiceI bookService;

    // Using GetMapping since it is a Get Request
    @GetMapping("/hello")  // localhost:8081/bookstore/api/hello
    public String sayHello() {
        return "Hello Spring Boot!";
    }

    // ResponseEntity is not generally used in spring boot
    @GetMapping("/book/isbn/{isbn}") //localhost:8081/bookstore/api/book/isbn/1234
    public ResponseEntity<Book> getBook(@PathVariable("isbn") Long isbn) {
        return bookService.getBook(isbn);
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/addbook")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/delete/isbn/{isbn}")
    public Book deleteBook(@PathVariable("isbn") Long isbn) {
        return bookService.delete(isbn);
    }

    @PutMapping("/update/isbn/{isbn}/stock/{newstock}")
    public Book updateNewStock(@PathVariable("isbn") Long isbn, @PathVariable("newstock") Long newStock) {
        return bookService.updateBook(isbn, newStock);
    }

}
