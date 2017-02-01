package com.example;

import com.example.entity.Book;
import com.example.repository.BookRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
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
        BookRepository repo = context.getBean(BookRepository.class);

        for (int i = 0; i < 4; i++) {
            repo.findByIds(1l,2l,3l);
        }
    }

}
