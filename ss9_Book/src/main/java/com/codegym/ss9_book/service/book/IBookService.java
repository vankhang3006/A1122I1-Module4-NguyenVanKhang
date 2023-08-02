package com.codegym.ss9_book.service.book;

import com.codegym.ss9_book.model.Book;
import com.codegym.ss9_book.service.IGeneralService;

public interface IBookService extends IGeneralService<Book> {
    Book findBookById(Long id);
}
