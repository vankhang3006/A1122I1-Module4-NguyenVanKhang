package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class DictionaryController {
    @GetMapping("/dictionary")
    public String index() {
        return "translate";
    }

    @PostMapping("/dictionary")
    public String submit(@RequestParam int id, Model model) {
        String[] arr = { "apple", "cat", "dog", "flower", "bird" };
        List<String> list = Arrays.asList(arr);
        String english = list.get(id-1);
        model.addAttribute("english", english);
        model.addAttribute("id",id);
        return "translate";
    }
}
