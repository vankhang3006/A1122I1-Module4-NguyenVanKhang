package com.codegym.service;

import com.codegym.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();

    void save(Comment comment);

    Comment update(Comment comment);

    Comment findById(int id);

    Comment like(int id);

}
