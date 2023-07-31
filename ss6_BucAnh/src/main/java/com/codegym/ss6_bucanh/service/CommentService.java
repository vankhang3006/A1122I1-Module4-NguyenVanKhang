package com.codegym.ss6_bucanh.service;

import com.codegym.ss6_bucanh.model.Comment;
import com.codegym.ss6_bucanh.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentService implements ICommentService{
    @Autowired
    private ICommentRepository commentRepository;
    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }


    @Override
    public Comment saveOrUpdate(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findCommentByDateCreate(LocalDate date) {
        return commentRepository.findCommentByDateCreate(date);
    }

    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id).orElse(null);
    }
}
