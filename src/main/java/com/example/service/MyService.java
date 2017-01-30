package com.example.service;

import com.example.entity.Book;

import java.util.List;

public interface MyService {

    String addBook(String name);
    boolean deleteBook();
    List<Book> getAllbook();
    Book getBookByName(String name);
    List<Book> findByIds(List<Long> idlist);

}
