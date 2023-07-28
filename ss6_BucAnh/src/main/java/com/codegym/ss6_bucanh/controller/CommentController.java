package com.codegym.ss6_bucanh.controller;

import com.codegym.ss6_bucanh.model.Comment;
import com.codegym.ss6_bucanh.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("comment", new Comment());
        List<Comment> comments = commentService.findCommentByDateCreate(LocalDate.now());
        modelAndView.addObject("comments", comments);
        return modelAndView;
    }

    @PostMapping
    public String save(Comment comment) {
        comment.setDateCreate(LocalDate.now());
        commentService.saveOrUpdate(comment);
        return "redirect:/home";
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable("id") int id) {
        Comment comment = commentService.findById(id);
        comment.setLikeCount(comment.getLikeCount()+1);
        commentService.saveOrUpdate(comment);
        return "redirect:/home";
    }
}
