package com.sang.cascade.service;

import com.sang.cascade.entity.presist.Book;
import org.springframework.stereotype.Component;

@Component
public interface BookService {
    public Book saveBook(Book book);
    public Book findByBookId(int bookId);
    public Book deleteBook(Book book);
}