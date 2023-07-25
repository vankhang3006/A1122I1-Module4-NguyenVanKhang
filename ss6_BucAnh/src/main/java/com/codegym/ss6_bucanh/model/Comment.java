package com.codegym.ss6_bucanh.model;

import jakarta.persistence.*;


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

    public Comment() {
    }

    public Comment(int rate, String author, String message) {
        this.rate = rate;
        this.author = author;
        this.message = message;
    }

    public Comment(int id, int rate, String author, String message, int likeCount) {
        this.id = id;
        this.rate = rate;
        this.author = author;
        this.message = message;
        this.likeCount = likeCount;
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

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
