package com.codegym.ss9_book.repository;

import com.codegym.ss9_book.model.Book;
import com.codegym.ss9_book.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Long> {
    Iterable<Ticket> findAllByBook(Book book);
    Ticket findTicketByCard(Long card);
}
