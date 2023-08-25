package com.example.ktmodule4.controller;

import com.example.ktmodule4.model.RentType;
import com.example.ktmodule4.service.renttype.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RentTypeController {
    @Autowired
    private IRentTypeService rentTypeService;
    @GetMapping("/rentTypes")
    public ModelAndView listRentTypes() {
        Iterable<RentType> rentTypes = rentTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/rentType/list");
        modelAndView.addObject("rentTypes", rentTypes);
        return modelAndView;
    }

    @GetMapping("/create-rentType")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/rentType/create");
        modelAndView.addObject("rentType", new RentType());
        return modelAndView;
    }

    @PostMapping("/create-rentType")
    public ModelAndView saveRentType(@ModelAttribute("rentType") RentType rentType) {
        rentTypeService.save(rentType);

        ModelAndView modelAndView = new ModelAndView("/rentType/create");
        modelAndView.addObject("rentType", new RentType());
        modelAndView.addObject("message", "Tạo khung giờ thuê mới thành công!");
        return modelAndView;
    }
}
