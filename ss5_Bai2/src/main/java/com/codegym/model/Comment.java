package com.codegym.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rate;
    private String author;
    private String message;
    private int likeCount;
    private LocalDate dateCreate;
    public Comment() {
    }

    public Comment(int rate, String author, String message, LocalDate dateCreate) {
        this.rate = rate;
        this.author = author;
        this.message = message;
        this.dateCreate = dateCreate;
    }

    public Comment(int id, int rate, String author, String message, int likeCount, LocalDate dateCreate) {
        this.id = id;
        this.rate = rate;
        this.author = author;
        this.message = message;
        this.likeCount = likeCount;
        this.dateCreate = dateCreate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
