package com.example;

import com.example.entity.Book;
import com.example.repository.BookRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringDataTestApplication {


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataTestApplication.class, args);

        //we can get injects with getbean of any Configuration or component(component like
        // @Inject on constructor without bean)
        // (repository is a compnent)
        BookRepository repo = context.getBean(BookRepository.class);


        //paging
//        for (int i = 0; i < 5; i++) {
//
//            for (Book book :
//                    repo.findAll(new PageRequest(i,2))) {
//                System.out.println(book.toString());
//            }
//            System.out.println("_ _____________________ _");
//        }

        for (Book book :
                repo.findByPageCountGreaterThan(300,new PageRequest(0,2))) {
            System.out.println(book.toString());
        }
    }

}
