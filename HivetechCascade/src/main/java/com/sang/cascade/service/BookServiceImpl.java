package com.sang.cascade.service;

import com.sang.cascade.Entity.presist.Book;
import com.sang.cascade.repo.BookRepository;
import com.sang.cascade.repo.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StoryRepository storyRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Book saveBook(Book book) {
        book = bookRepository.save(book);
        return book;
    }

    @Transactional
    public Book deleteBook(Book book) {
        bookRepository.delete(book);
        return book;
    }

    public Book findByBookId(int bookId) {
        Optional<Book> bookResponse = bookRepository.findById(bookId);
        Book book = bookResponse.get();
        return book;
    }
}