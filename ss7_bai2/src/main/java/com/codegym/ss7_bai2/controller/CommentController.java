package com.codegym.ss7_bai2.controller;


import com.codegym.ss7_bai2.exception.CommentException;
import com.codegym.ss7_bai2.model.Comment;
import com.codegym.ss7_bai2.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/home")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping
    public ModelAndView home(@PageableDefault(size = 2,page = 0,direction = Sort.Direction.ASC) Pageable pageable
                            ) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("comment", new Comment());
        Page<Comment> comments = commentService.findAll(pageable,LocalDate.now());
        modelAndView.addObject("comments", comments);
        return modelAndView;
    }

    @PostMapping
    public String save(Comment comment) throws CommentException {
        comment.setDateCreate(LocalDate.now());
        commentService.saveOrUpdate(comment);
        return "redirect:/home";
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable("id") int id) throws CommentException {
        Comment comment = commentService.findById(id);
        comment.setLikeCount(comment.getLikeCount()+1);
        commentService.saveOrUpdate(comment);
        return "redirect:/home";
    }
    @ExceptionHandler(CommentException.class)
    public String commentException(){
        return "comment_exception";
    }
}
