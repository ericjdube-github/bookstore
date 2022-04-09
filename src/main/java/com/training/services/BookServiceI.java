package com.training.services;

import com.training.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by ericjdube on 4/8/2022 8:53 PM
 */
public interface BookServiceI {

    public Book addBook(Book book);
    public List<Book> getBooks();
    public ResponseEntity<Book> getBook(Long isbn);

    // delete a book
    public Book delete(Long isbn);

    // update the stock
    public Book updateBook(Long isbn, Long newStock);

}
