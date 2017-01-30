package com.example;

import com.example.entity.Book;
import com.example.repository.BookRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class SpringDataTestApplication {


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataTestApplication.class, args);

        //we can get injects with getbean of any Configuration or component(component like @Inject on constructor without bean)
        // (repository is a compnent)
        BookRepository repo = context.getBean(BookRepository.class);

//        editOrInsert(repo);
//        deleteItems(repo);
        deleteItems2(repo);

    }

    private static void deleteItems2(BookRepository repo) {
        //not good cause it is multiple transaction
        repo.deleteInBatch(repo.findAll(new ArrayList<Long>(){{
            add(1l);
            add(2l);
            add(3l);
        }}));
    }

    private static void deleteItems(BookRepository repo) {

        repo.delete(repo.findAll(new ArrayList<Long>(){{
            add(1l);
            add(2l);
            add(3l);
        }}));
    }

    private static void editOrInsert(BookRepository repo) {

        //        Book book = new Book();
        Book book = repo.findOne(1l);
        book.setTitle("عاشقانه های آرام مهدی");
        // if this id not exist spring insert this record as new one
        book.setBookId(1000l);
        repo.save(book);
        System.out.println(book);
    }

}
