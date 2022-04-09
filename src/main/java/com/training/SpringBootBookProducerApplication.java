package com.training;

import com.training.model.Book;
import com.training.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class SpringBootBookProducerApplication /* implements CommandLineRunner */ {

    @Autowired
    private BookRepo bookRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBookProducerApplication.class, args);
    }

    @PostConstruct
    public void saveBooks() {
        bookRepo.save(new Book(1234L, "C", 120.60, 1001L, LocalDate.now()));
        bookRepo.save(new Book(2222L, "C", 100.60, 1L, LocalDate.now()));
        bookRepo.save(new Book(1238L, "C++", 55.60, 5L, LocalDate.now()));
        bookRepo.save(new Book(1235L, "Java", 220.60, 1011L, LocalDate.now()));
        bookRepo.save(new Book(1236L, "Python", 320.60, 1021L, LocalDate.now()));
        bookRepo.save(new Book(1237L, "Angular", 420.60, 1031L, LocalDate.now()));
    }

    // CommandLineRunner
    @Bean
    public CommandLineRunner getRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println(bookRepo.findByTitle("C"));
            System.out.println(bookRepo.findByTitleLike("C%"));
            System.out.println(bookRepo.getByStockIsGreater(1021l));
        };
    }

//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println(bookRepo.findByTitle("C"));
//    }
}
