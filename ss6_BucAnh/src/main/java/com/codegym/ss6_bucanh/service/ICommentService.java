package com.codegym.ss6_bucanh.service;

import com.codegym.ss6_bucanh.model.Comment;

import java.time.LocalDate;
import java.util.List;

public interface ICommentService {
    List<Comment> findAll();

    Comment saveOrUpdate(Comment comment);
    List<Comment> findCommentByDateCreate(LocalDate date);

    Comment findById(int id);
}
