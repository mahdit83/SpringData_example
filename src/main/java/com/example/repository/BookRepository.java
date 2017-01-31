package com.example.repository;

import com.example.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String bookName);

    List<Book> findByTitleLike(String bookName);

    List<Book> findByTitleContaining(String bookName);

    List<Book> findByTitleStartingWith(String bookName);

    List<Book> findByTitleEndingWith(String bookName);

    List<Book> findByTitleIgnoreCase(String bookName);

    //relational operations
    List<Book> findByPageCountGreaterThan(int pageCount);
    List<Book> findByPageCountGreaterThanEqual(int pageCount);
    List<Book> findByPageCountLessThanEqual(int pageCount);
    List<Book> findByPageCountBetween(int min, int max);

}
