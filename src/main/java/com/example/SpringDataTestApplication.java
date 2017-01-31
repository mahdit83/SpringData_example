package com.example;

import com.example.entity.Book;
import com.example.repository.BookRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

//        for (Book book :
//                repo.findByPageCountGreaterThan(300,new PageRequest(0,2))) {
//            System.out.println(book.toString());
//        }

        for (Book book :
                repo.findAll(new Sort(Sort.Direction.DESC,"pageCount").and(new Sort("author.lastName")))) {
            System.out.println(book.toString());
        }

        for (Book book :
                // first asc the author name and when it is the same sort by page count
                repo.findAll(new Sort(Sort.Direction.ASC,"author.lastName","pageCount"))) {
            System.out.println(book.toString());
        }

        List<Book> page = repo.findByPageCountGreaterThan(100, new PageRequest(0,2));


    }

}
