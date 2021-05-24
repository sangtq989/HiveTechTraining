package com.sang.cascade.repo;

import com.sang.cascade.entity.presist.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface BookRepository extends CrudRepository<Book, Serializable> {
    Book findByBookId(int bookId);
}