package com.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by ericjdube on 4/8/2022 5:17 PM
 */

@NoArgsConstructor
@AllArgsConstructor
@Data //Lombok Data annotation ( @Data ) Generates getters for all fields, a useful toString method, and hashCode and equals implementations that check all non-transient fields. Will also generate setters for all non-final fields, as well as a constructor.Mar 8, 2021
@Entity // defines that a class can be mapped to a table
public class Book {

    @Id  // primary key
    private Long isbn;

    @Column(name = "book_title")
    private String title;

    private Double price;
    private Long stock;
    private LocalDate dateOfPublishing;


}
