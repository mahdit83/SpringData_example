package com.example.controller;

import com.example.entity.Book;
import com.example.service.MyServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {


    @Autowired
    MyServiceImpl myService;


    @RequestMapping("/books")
    public List<Book> getAllbooks(){
        return myService.getAllbook();

    }

    @RequestMapping("/book/add/{book_name}")
    public String addBook(@PathVariable("book_name")String bookName){
        return myService.addBook(bookName);
    }

    @RequestMapping(value = "/book/{book_name}", method = RequestMethod.GET)
    public Book getBook(@PathVariable("book_name")String bookName){
        return myService.getBookByName(bookName);
    }

    @RequestMapping( value = "/books/{idlist}", method = RequestMethod.GET)
    public List<Book> getbooksByIds(@PathVariable List<Long> idlist){
        return myService.findByIds(idlist);
    }

}
