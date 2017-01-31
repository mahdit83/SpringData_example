package com.example;

import com.example.entity.Book;
import com.example.repository.BookRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
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

        for (Book book :
                repo.findByTitleEndingWith("s")) {
            System.out.println("------ "+book.getTitle());
        }

        for (Book book :
                repo.findByPageCountBetween(10, 300)) {
            System.out.println(book.getTitle());
        }

    }


}
