package com.example.ktmodule4.controller;

import com.example.ktmodule4.dto.StadiumDto;
import com.example.ktmodule4.model.Area;
import com.example.ktmodule4.model.RentType;
import com.example.ktmodule4.model.Stadium;
import com.example.ktmodule4.model.Type;
import com.example.ktmodule4.service.area.IAreaService;
import com.example.ktmodule4.service.renttype.IRentTypeService;
import com.example.ktmodule4.service.stadium.IStadiumService;
import com.example.ktmodule4.service.type.ITypeService;
import com.example.ktmodule4.utils.FormatUtils;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class StadiumController {
    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IAreaService areaService;

    @Autowired
    private ITypeService typeService;

    @Autowired
    private IStadiumService stadiumService;

    @ModelAttribute("rentTypes")
    public Iterable<RentType> rentTypes() {
        return rentTypeService.findAll();
    }

    @ModelAttribute("areas")
    public Iterable<Area> areas() {
        return areaService.findAll();
    }

    @ModelAttribute("types")
    public Iterable<Type> types() {
        return typeService.findAll();
    }

    @GetMapping("/stadiums")
    public ModelAndView listStadiums(@PageableDefault(size = 3, page = 0,direction = Sort.Direction.ASC) Pageable pageable,
                                     @RequestParam(name = "nameSearch",defaultValue = "") String nameSearch,
                                     @RequestParam(name = "areaSearch",defaultValue = "") String areaSearch,
                                     @RequestParam(name = "peopleSearch",defaultValue = "") String peopleSearch) {

        Page<Stadium> stadiums = stadiumService.findByNameContainingAndArea_NameAndType_PeopleAmount(nameSearch,areaSearch,peopleSearch,pageable);
        ModelAndView modelAndView = new ModelAndView("/stadium/list");
        List<String> formatPrices = rentTypeService.priceList();
        modelAndView.addObject("prices", formatPrices);
        modelAndView.addObject("stadiums", stadiums);
        modelAndView.addObject("nameSearch", nameSearch);
        modelAndView.addObject("areaSearch", areaSearch);
        modelAndView.addObject("peopleSearch", peopleSearch);
        return modelAndView;
    }


    @GetMapping("/create-stadium")
    public String showCreateForm(Model model) {
        model.addAttribute("stadiumDto",new StadiumDto());
        return "/stadium/create";
    }

    @PostMapping("/create-stadium")
    public String saveStadium(@Valid @ModelAttribute StadiumDto stadiumDto,
                                    BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
        stadiumDto.validateNameUnique(stadiumService,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "Thêm mới không thành công!");
            return "/stadium/create";
        }
            Stadium stadium = new Stadium();
            BeanUtils.copyProperties(stadiumDto,stadium);
            stadiumService.save(stadium);
            redirectAttributes.addFlashAttribute("message","Thêm mới thành công!!");
            return "redirect:/stadiums";
    }
    @GetMapping("/detail-stadium/{id}")
    public ModelAndView showDetailForm(@PathVariable int id) {
        Optional<Stadium> stadium = stadiumService.findById(id);
        if (stadium.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/stadium/detail");
            modelAndView.addObject("stadium", stadium.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        stadiumService.remove(id);
        return "redirect:/stadiums";
    }
}
