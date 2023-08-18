package com.codegym.phonemanagement.controller;

import com.codegym.phonemanagement.service.SmartPhoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
@AllArgsConstructor
public class HomeController {
    private final SmartPhoneService smartPhoneService;

    @GetMapping
    public ModelAndView getAllSmartphonePage() {
        return new ModelAndView("/list", "smartphones", smartPhoneService.findAll());
    }
}
