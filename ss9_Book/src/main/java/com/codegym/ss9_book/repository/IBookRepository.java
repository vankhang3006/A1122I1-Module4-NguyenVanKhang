package com.codegym.ss9_book.repository;

import com.codegym.ss9_book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
    Book findBookById(Long id);

}
