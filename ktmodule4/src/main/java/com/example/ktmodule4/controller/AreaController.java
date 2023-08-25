package com.example.ktmodule4.controller;

import com.example.ktmodule4.model.Area;
import com.example.ktmodule4.service.area.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AreaController {
    @Autowired
    private IAreaService areaService;
    @GetMapping("/areas")
    public ModelAndView listAreas() {
        Iterable<Area> areas = areaService.findAll();
        ModelAndView modelAndView = new ModelAndView("/area/list");
        modelAndView.addObject("areas", areas);
        return modelAndView;
    }

    @GetMapping("/create-area")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/area/create");
        modelAndView.addObject("area", new Area());
        return modelAndView;
    }

    @PostMapping("/create-area")
    public ModelAndView saveArea(@ModelAttribute("area") Area area) {
        areaService.save(area);

        ModelAndView modelAndView = new ModelAndView("/area/create");
        modelAndView.addObject("area", new Area());
        modelAndView.addObject("message", "Tạo khu vực mới thành công!");
        return modelAndView;
    }
}
