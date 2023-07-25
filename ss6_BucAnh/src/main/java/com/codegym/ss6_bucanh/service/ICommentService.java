package com.codegym.ss6_bucanh.service;

import com.codegym.ss6_bucanh.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();


    Comment saveOrUpdate(Comment comment);

    Comment findById(int id);
}
