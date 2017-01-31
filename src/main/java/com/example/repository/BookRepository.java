package com.example.repository;

import com.example.entity.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String bookName);

    List<Book> findByTitleLikeOrderByTitleAsc(String bookName);
    List<Book> findByTitleContainingOrderByTitleDesc(String bookName);
    List<Book> findByTitleStartingWith(String bookName);
    List<Book> findByTitleEndingWith(String bookName);
    List<Book> findByTitleIgnoreCase(String bookName);

    //relational operations
    List<Book> findByPageCountGreaterThan(int pageCount);
    List<Book> findByPageCountGreaterThanEqual(int pageCount);
    List<Book> findByPageCountLessThanEqual(int pageCount);
    List<Book> findByPageCountBetween(int min, int max);

    //logical operations
    List<Book> findByTitleContainingOrTitleContaining(String param1, String param2);
    List<Book> findByTitleContainingAndPageCountGreaterThan(String param1, int param2);
    List<Book> findByTitleNotContaining(String param1);
    List<Book> findByTitleNot(String param1);

    //limiting query result
    List<Book> findTopByOrderByPageCountDesc();
    List<Book> findFirstByOrderByPageCountDesc(); //same top
    List<Book> findTop3ByOrderByPriceDesc();


    List<Book> findByAuthorFirstName(String arg);
    List<Book> findByAuthorCountry(String arg);
    List<Book> findByAuthor_Country(String arg); //this also works

    //additional techniques (this is easier that second method)
//    @Query("select b from Book b")
//    List<Book> queryOne();
//
//    @Query("select b from Book b where b.pageCount > ?1")
//    List<Book> queryTwo(int count);
//
//    @Query("select b from Book b where b.title = :title")
//    List<Book> queryThree(@Param("title") String param);

    //additional techniques 2
    List<Book> queryOne();

    List<Book> queryTwo(int pageCount);

    List<Book> queryThree(@Param("title") String title);

    //paging and and sorting

//    List<Book> findByPageCountGreaterThan(int pageCount, Pageable pageable);
//    List<Book> findByPageCountGreaterThan(int pageCount, Sort sortable);

    Page<Book> findByPageCountGreaterThan(int pageCount, Pageable pageable);

}
