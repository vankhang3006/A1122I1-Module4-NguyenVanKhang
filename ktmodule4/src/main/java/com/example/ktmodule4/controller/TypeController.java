package com.example.ktmodule4.controller;

import com.example.ktmodule4.model.Type;
import com.example.ktmodule4.service.type.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TypeController {
    @Autowired
    private ITypeService typeService;
    @GetMapping("/types")
    public ModelAndView listTypes() {
        Iterable<Type> types = typeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/type/list");
        modelAndView.addObject("types", types);
        return modelAndView;
    }

    @GetMapping("/create-type")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/type/create");
        modelAndView.addObject("type", new Type());
        return modelAndView;
    }

    @PostMapping("/create-type")
    public ModelAndView saveType(@ModelAttribute("type") Type type) {
        typeService.save(type);

        ModelAndView modelAndView = new ModelAndView("/type/create");
        modelAndView.addObject("type", new Type());
        modelAndView.addObject("message", "Tạo kiểu sân mới thành công!");
        return modelAndView;
    }
}
