package com.codegym.controller;

import com.codegym.model.Health;
import com.codegym.service.HealthService;
import com.codegym.service.IHealthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/health")
public class HealthController {
    private final IHealthService healthService = new HealthService();
    @GetMapping("")
    public String list(Model model) {
        List<Health> healths = healthService.findAll();
        model.addAttribute("healths", healths);
        return "/list";
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("health", new Health());
        return modelAndView;
    }
    @PostMapping("/save")
    public String saveHealth(Health health) {
        health.setId(healthService.findAll().size()+1);
        healthService.save(health);
        return "redirect:/health";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("health", healthService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(Health health) {
        healthService.update(health.getId(), health);
        return "redirect:/health";
    }
}
