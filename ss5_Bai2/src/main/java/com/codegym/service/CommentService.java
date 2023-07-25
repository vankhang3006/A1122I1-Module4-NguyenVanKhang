package com.codegym.service;

import com.codegym.model.Comment;
import com.codegym.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService implements ICommentService {

    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        return commentRepository.update(comment);
    }

    @Override
    public Comment like(int id) {
        return commentRepository.like(id);
    }

    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id);
    }
}
