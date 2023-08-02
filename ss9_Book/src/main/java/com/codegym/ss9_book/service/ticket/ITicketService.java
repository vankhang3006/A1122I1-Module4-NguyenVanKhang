package com.codegym.ss9_book.service.ticket;

import com.codegym.ss9_book.exception.BookException;
import com.codegym.ss9_book.exception.ExistException;
import com.codegym.ss9_book.model.Book;
import com.codegym.ss9_book.model.Ticket;
import com.codegym.ss9_book.service.IGeneralService;

public interface ITicketService extends IGeneralService<Ticket> {
    Iterable<Ticket> findAllByBook(Book book);
    void deleteTicketByCard(Long card) throws ExistException;
    Ticket findTicketByCard(Long card);
    void saveTicket(Ticket ticket) throws BookException;
}
