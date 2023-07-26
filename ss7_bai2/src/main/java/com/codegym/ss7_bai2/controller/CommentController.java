package com.codegym.ss7_bai2.controller;


import com.codegym.ss7_bai2.model.Comment;
import com.codegym.ss7_bai2.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
        Page<Comment> comments = commentService.findAll(pageable);
        modelAndView.addObject("comments", comments);
        return modelAndView;
    }

    @PostMapping
    public String save(Comment comment) {
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
