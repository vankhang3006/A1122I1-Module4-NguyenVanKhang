package com.example.thi.dto;

import com.example.thi.model.Type;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class QuestionDto implements Validator {
    private int id;
    @Size(message = "không đúng độ dài quy định",min = 5,max = 100)
    private String title;
    @Size(message = "không đúng độ dài quy định",min = 10,max = 500)
    private String content;
    private String answer;
    private LocalDate dateCreate;
    private int status;
    private Type type;

    public QuestionDto() {
    }

    public QuestionDto(int id, String title, String content, String answer, LocalDate dateCreate, int status, Type type) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
