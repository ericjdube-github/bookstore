package com.training.services;

import com.training.model.Book;
import com.training.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

/**
 * Created by ericjdube on 4/8/2022 9:00 PM
 */
@Service
public class BookService implements BookServiceI {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    @Override
    public ResponseEntity<Book> getBook(Long isbn) {
        Optional<Book> bookOp = bookRepo.findById(isbn);

        Book bookFound=null;
        if (bookOp.isPresent()) {
            bookFound = bookOp.get();
            return new ResponseEntity(bookFound, HttpStatus.OK);
        }

        return null;
    }

    @Override
    public Book delete(Long isbn) {
        Optional<Book> bookOp = bookRepo.findById(isbn);

        Book bookFound=null;
        if (bookOp.isPresent()) {
            bookFound = bookOp.get();
            bookRepo.delete(bookFound);

            return bookFound;
        }

        return null;
    }

    @Override
    public Book updateBook(Long isbn, Long newStock) {
        Optional<Book> bookOp = bookRepo.findById(isbn);

        Book bookFound=null;
        if (bookOp.isPresent()) {
            bookFound = bookOp.get();
            bookFound.setStock(bookFound.getStock() + newStock);
            bookRepo.save(bookFound);

            return bookFound;
        }

        return null;
    }
}
