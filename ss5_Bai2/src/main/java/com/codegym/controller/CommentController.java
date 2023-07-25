package com.codegym.controller;

import com.codegym.model.Comment;
import com.codegym.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        List<Comment> comments = commentService.findAll();
        modelAndView.addObject("comments", comments);
        return modelAndView;
    }

    @PostMapping
    public String save(Comment comment) {
        commentService.save(comment);
        return "redirect:/home";
    }

    @PostMapping(value = "like/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Comment> like(@PathVariable(name = "id") int id) {
        Comment comment = commentService.like(id);
        System.out.println(comment.getLikeCount());
        if (comment == null) {
            return new ResponseEntity<>(comment, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
}
