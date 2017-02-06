package com.example.repository;

import com.example.entity.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends BaseRepository<Book, Long> {

    Book findByTitle(String bookName);

    @Transactional  // query is executed with transaction
    @Modifying // indicate that this method contains that update or edit entities
    @Query("update Book b set b.pageCount = ?2 where b.title like ?1")
    public int setPageCount(String title, int pageCount);

}
