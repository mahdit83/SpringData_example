package com.example.repository;

import com.example.entity.Book;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class BookRepositoryImpl implements BookRepositoryCustom {

    private static Logger logger = LoggerFactory.getLogger(BookRepositoryImpl.class);

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveAndLog(Book book) {


        logger.debug("saving the book entiry "+book.toString());
        System.out.println("saving the book entiry "+book.toString());
        entityManager.persist(book);
    }
}
