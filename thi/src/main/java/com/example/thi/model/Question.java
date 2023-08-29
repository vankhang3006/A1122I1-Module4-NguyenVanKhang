package com.example.thi.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private String answer;
    private LocalDate dateCreate;
    private int status;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    public Question() {
    }

    public Question(int id, String title, String content, String answer, LocalDate dateCreate, int status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.dateCreate = dateCreate;
        this.status = status;
    }

    public Question(int id, String title, String content, String answer, LocalDate dateCreate, int status, Type type) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.dateCreate = dateCreate;
        this.status = status;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
