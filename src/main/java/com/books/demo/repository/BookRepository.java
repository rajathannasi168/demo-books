package com.books.demo.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import com.books.demo.domain.Book;

/**
 * @author rt3
 *
 */
@Repository
public interface BookRepository extends R2dbcRepository<Book, Integer> {}