package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CondimentController {

    @GetMapping("/save")
    public String index() {
        return "save";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("condiments",condiment);
        return "condimentList";
    }
}
