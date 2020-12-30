package com.sang.cascade.controller;

import com.sang.cascade.Entity.presist.Book;
import com.sang.cascade.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping(value = "/savebook",method = RequestMethod.POST)
    @ResponseBody
    public Book saveBook(@RequestBody Book book) {
        Book bookResponse = bookService.saveBook(book);
        return bookResponse;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Book updateBook(@RequestBody Book book) {
        Book bookResponse = (Book) bookService.saveBook(book);
        return bookResponse;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Book deleteBook(@RequestBody Book book) {
        Book bookResponse = (Book) bookService.deleteBook(book);
        return bookResponse;
    }

    @RequestMapping(value = "/{bookId}",method = RequestMethod.GET)
    @ResponseBody
    public Book getBookDetails(@PathVariable int bookId) {
        Book bookResponse = bookService.findByBookId(bookId);

        return bookResponse;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleStorageFileNotFound(Exception exc) {
        return new ResponseEntity(exc.getMessage(), HttpStatus.I_AM_A_TEAPOT);
    }
}