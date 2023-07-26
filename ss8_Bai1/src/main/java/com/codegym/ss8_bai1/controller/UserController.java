package com.codegym.ss8_bai1.controller;

import com.codegym.ss8_bai1.dto.UserDto;
import com.codegym.ss8_bai1.model.User;
import com.codegym.ss8_bai1.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String showFormCreate(Model model){
        model.addAttribute("userDto",new UserDto());
        return "index";
    }
    @PostMapping("/create")
    public String save(@Valid @ModelAttribute UserDto userDto,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes redirectAttributes){
        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "index";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.save(user);
        return "result";
    }
}
