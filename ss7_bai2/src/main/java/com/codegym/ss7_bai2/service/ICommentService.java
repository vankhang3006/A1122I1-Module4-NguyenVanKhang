package com.codegym.ss7_bai2.service;


import com.codegym.ss7_bai2.exception.CommentException;
import com.codegym.ss7_bai2.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface ICommentService extends IGeneralService<Comment>{
    Page<Comment> findAll(Pageable pageable);
    Page<Comment> findAll(Pageable pageable, LocalDate date);

    List<Comment> findAll();
    Comment saveOrUpdate(Comment comment) throws CommentException;
    Comment findById(int id);
}
