package com.example.service;

import com.example.entity.Book;
import com.example.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

@Component
public class MyServiceImpl implements MyService {

    @Autowired
    private EntityManager em;

    @Autowired
    private BookRepository repo;

    @Override
    public String addBook(String bookName) {

        Book book = new Book();
        book.setTitle(bookName);
        book.setPublishDate(new Date());
        book.setPrice(new BigDecimal(Math.random()));
        book.setPageCount(new Random().nextInt(1000));
        repo.save(book);
        return "added successfully!";

    }

    @Override
    public boolean deleteBook() {

        return false;
    }

    @Override
    public List<Book> getAllbook() {
        return em.createQuery("select s from Book s").getResultList();
    }

    @Override
    public Book getBookByName(String name) {
        return repo.findByTitle(name);
    }

    @Override
    public List<Book> findByIds(List<Long> idlist) {
        return repo.findAll(idlist);
    }
}
