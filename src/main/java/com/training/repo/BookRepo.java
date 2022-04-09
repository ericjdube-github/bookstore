package com.training.repo;

import com.training.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ericjdube on 4/8/2022 6:16 PM
 */
@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
}
