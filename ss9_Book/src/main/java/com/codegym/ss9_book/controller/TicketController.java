package com.codegym.ss9_book.controller;

import com.codegym.ss9_book.exception.BookException;
import com.codegym.ss9_book.exception.ExistException;
import com.codegym.ss9_book.model.Book;
import com.codegym.ss9_book.model.Ticket;
import com.codegym.ss9_book.service.book.IBookService;
import com.codegym.ss9_book.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

@Controller
public class TicketController {
    @Autowired
    private ITicketService ticketService;

    @Autowired
    private IBookService bookService;

    @ModelAttribute("books")
    public Iterable<Book> books(){
        return bookService.findAll();
    }


    @GetMapping("/create-ticket/{id}")
    public ModelAndView showCreateForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/ticket/create");
        Random random = new Random();
        Long card = 10000L + random.nextInt(90000);
        Book book = bookService.findBookById(id);
        modelAndView.addObject("ticket", new Ticket("",card,book));
        return modelAndView;
    }

    @PostMapping("/create-ticket")
    public ModelAndView saveTicket(@ModelAttribute("ticket") Ticket ticket) throws BookException {
//        Book book = bookService.findBookById(ticket.getBook().getId());
//        book.setQuantity(book.getQuantity()-1);
//        bookService.save(book);
        ticketService.saveTicket(ticket);
//        Iterable<Book> books = bookService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/book/list");
//        modelAndView.addObject("books", books);
//        return modelAndView;
        ModelAndView modelAndView = new ModelAndView("/ticket/create");
//        modelAndView.addObject("ticket", new Ticket());
        modelAndView.addObject("message", "New ticket created successfully");
        return modelAndView;
    }

    @GetMapping("/tickets")
    public ModelAndView listTickets(){
        Iterable<Ticket> tickets = ticketService.findAll();
        ModelAndView modelAndView = new ModelAndView("/ticket/list");
        modelAndView.addObject("tickets", tickets);
        return modelAndView;
    }


    @GetMapping("/edit-ticket/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.findById(id);
        if (ticket.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/ticket/edit");
            modelAndView.addObject("ticket", ticket.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-ticket")
    public ModelAndView updateTicket(@ModelAttribute("ticket") Ticket ticket) throws BookException {
        ticketService.save(ticket);
        ModelAndView modelAndView = new ModelAndView("/ticket/edit");
        modelAndView.addObject("ticket", ticket);
        modelAndView.addObject("message", "Ticket updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-ticket/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.findById(id);
        if (ticket.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/ticket/delete");
            modelAndView.addObject("ticket", ticket.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-ticket")
    public String deleteTicket(@ModelAttribute("ticket") Ticket ticket) {
        ticketService.remove(ticket.getId());
        return "redirect:tickets";
    }

    @GetMapping("/detail-ticket/{id}")
    public ModelAndView showDetailForm(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.findById(id);
        if (ticket.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/ticket/detail");
            modelAndView.addObject("ticket", ticket.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @GetMapping("/return-ticket")
    public ModelAndView showReturnForm() {
        ModelAndView modelAndView = new ModelAndView("/ticket/return");
        modelAndView.addObject("search",0l);
        return modelAndView;
    }
    @PostMapping("/return-ticket")
    public ModelAndView returnBook(@ModelAttribute("search") Long search) throws ExistException {
        ticketService.deleteTicketByCard(search);
        ModelAndView modelAndView = new ModelAndView("/ticket/return");
        modelAndView.addObject("search", "");
        modelAndView.addObject("message", "Return book successfully");
        return modelAndView;
    }
    @ExceptionHandler(BookException.class)
    public String bookException(){
        return "book_exception";
    }


    @ExceptionHandler(ExistException.class)
    public String existException(){
        return "error.404";
    }
}
