package com.codegym.ss7_bai2.service;


import com.codegym.ss7_bai2.exception.CommentException;
import com.codegym.ss7_bai2.model.Comment;
import com.codegym.ss7_bai2.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService{

    private  static List<String> badWords = new ArrayList<>();
    static {
        badWords.add("fuck");
        badWords.add("shit");
        badWords.add("bitch");
    }
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public Page<Comment> findAll(Pageable pageable, LocalDate date) {
        return commentRepository.findCommentByDateCreate(pageable,date);
    }


    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment saveOrUpdate(Comment comment) throws CommentException {
        for(String w : badWords){
            if (comment.getMessage().contains(w)){
                throw new CommentException("Bình luận của bạn đã vi phạm tiêu chuẩn của cộng đồng!");
            }
        }
        return commentRepository.save(comment);
    }


    @Override
    public Optional<Comment> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Comment comment) {

    }

    @Override
    public void remove(Long id) {

    }


    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id).orElse(null);
    }
}
