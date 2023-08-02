package com.codegym.ss9_book.service.ticket;

import com.codegym.ss9_book.exception.BookException;
import com.codegym.ss9_book.exception.ExistException;
import com.codegym.ss9_book.model.Book;
import com.codegym.ss9_book.model.Ticket;
import com.codegym.ss9_book.repository.IBookRepository;
import com.codegym.ss9_book.repository.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService implements ITicketService{
    @Autowired
    private ITicketRepository ticketRepository;

    @Autowired
    private IBookRepository bookRepository;
    @Override
    public Iterable<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void saveTicket(Ticket ticket) throws BookException {
        Book book = bookRepository.findBookById(ticket.getBook().getId());
        if(book.getQuantity() == 0 ){
            throw new BookException("Sách này hiện đã hết");
        }
        book.setQuantity(book.getQuantity()-1);
        bookRepository.save(book);
        ticketRepository.save(ticket);
    }

    @Override
    public void remove(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public Iterable<Ticket> findAllByBook(Book book) {
        return ticketRepository.findAllByBook(book);
    }

    @Override
    public void deleteTicketByCard(Long card) throws ExistException {
        Ticket ticket = ticketRepository.findTicketByCard(card);
        if(ticket == null){
            throw new ExistException("Mã mượn sách không tồn tại");
        }
        Book book = bookRepository.findBookById(ticket.getBook().getId());
        book.setQuantity(book.getQuantity()+1);
        bookRepository.save(book);
        ticketRepository.deleteById(ticket.getId());
    }

    @Override
    public Ticket findTicketByCard(Long card) {
        return ticketRepository.findTicketByCard(card);
    }
}
