package com.training;

import com.training.model.Book;
import com.training.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootBookProducerApplication {

    @Autowired
    private BookRepo bookRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBookProducerApplication.class, args);
    }

    @PostConstruct
    public void saveBooks() {
        bookRepo.save(new Book(1234L, "C", 120.60, 1001L));
        bookRepo.save(new Book(1235L, "Java", 220.60, 1011L));
        bookRepo.save(new Book(1236L, "Python", 320.60, 1021L));
        bookRepo.save(new Book(1237L, "Angular", 420.60, 1031L));
    }
}
