package com.codegym.ss6_bai2.controller;

import com.codegym.ss6_bai2.model.Blog;
import com.codegym.ss6_bai2.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Blog> blogs = blogService.findAll();
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("info");
        Blog blog = blogService.findById(id);
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute Blog blog,
                       Model model,
                       RedirectAttributes redirectAttributes){
        blogService.create(blog);
        redirectAttributes.addFlashAttribute("mess","thêm mới thành công");
        return "redirect:/blogs";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        blogService.remove(id);
        return "redirect:/blogs";
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Blog blog = blogService.findById(id);
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog,
                       Model model,
                       RedirectAttributes redirectAttributes){
        blogService.update(blog.getId(), blog);
        redirectAttributes.addFlashAttribute("mess","cập nhật thành công");
        return "redirect:/blogs";
    }
}
