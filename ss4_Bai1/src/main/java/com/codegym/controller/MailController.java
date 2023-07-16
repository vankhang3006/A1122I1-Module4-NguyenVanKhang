package com.codegym.controller;

import com.codegym.model.Mail;
import com.codegym.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private IMailService mailService;
    //    @GetMapping("/mail")
//    public String showList(Model model){
//        List<Mail> mailList = mailService.findAll();
//        model.addAttribute("mailList",mailList);
//        return "list";
//    }
    @GetMapping("/list")
    public ModelAndView showList(){
        List<Mail> mailList = mailService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("mailList",mailList);
        return modelAndView ;
    }
    @GetMapping("")
    public String showFormCreate(Model model){
        model.addAttribute("mail",new Mail());
        return "create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute Mail mail,
                       Model model,
                       RedirectAttributes redirectAttributes){
        mailService.save(mail);
        redirectAttributes.addFlashAttribute("mess","thêm mới thành công");
        return "redirect:/mail/list";
    }
}
