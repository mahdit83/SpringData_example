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
//
    List<Book> findByTitleEndingWith(String bookName);

    List<Book> findByTitleIgnoreCase(String bookName);
}
