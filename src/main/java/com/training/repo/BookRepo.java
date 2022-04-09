package com.training.repo;

import com.training.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ericjdube on 4/8/2022 6:16 PM
 */
@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    // retrieve all C Books (based on Title)
    List<Book> findByTitle(String title);
    List<Book> findByTitleLike(String pattern);

    @Query("from Book b where b.stock > :stock")
    List<Book> getByStockIsGreater(@Param("stock") Long stock);
}
