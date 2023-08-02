package com.codegym.ss9_book.formatter;



import com.codegym.ss9_book.model.Book;
import com.codegym.ss9_book.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class BookFormatter implements Formatter<Book> {
    private IBookService bookService;
    @Autowired
    public BookFormatter(IBookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Book parse(String text, Locale locale) throws ParseException {
        Optional<Book> bookOptional = bookService.findById(Long.parseLong(text));
        return bookOptional.orElse(null);
    }

    @Override
    public String print(Book object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
