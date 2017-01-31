package com.example.repository;

import com.example.entity.Book;

public interface BookRepositoryCustom {

    void saveAndLog(Book book);
}
