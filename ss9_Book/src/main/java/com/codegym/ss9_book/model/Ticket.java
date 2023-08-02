package com.codegym.ss9_book.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String person;
    @Column(unique = true)
    private Long card;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Ticket() {
    }

    public Ticket(String person, Long card) {
        this.person = person;
        this.card = card;
    }

    public Ticket(String person, Long card, Book book) {
        this.person = person;
        this.card = card;
        this.book = book;
    }
    @Override
    public String toString() {
        return String.format("Ticket[id=%d, person='%s', card='%s']", id, person, card);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public Long getCard() { return card; }

    public void setCard(Long card) {
        this.card = card;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
