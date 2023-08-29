package com.example.thi.controller;

import com.example.thi.dto.QuestionDto;
import com.example.thi.model.Question;
import com.example.thi.model.Type;
import com.example.thi.service.IQuestionService;
import com.example.thi.service.ITypeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class QuestionController {
    @Autowired
    private ITypeService typeService;

    @Autowired
    private IQuestionService questionService;

    @ModelAttribute("types")
    public Iterable<Type> types() {
        return typeService.findAll();
    }

    @GetMapping("/questions")
    public ModelAndView listQuestions(@PageableDefault(size = 3, page = 0) Pageable pageable,
                                     @RequestParam(name = "titleSearch",defaultValue = "", required = false) String titleSearch,
                                     @RequestParam(name = "typeSearch",defaultValue = "", required = false) String typeSearch
                                     ) {
        pageable = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),Sort.by("dateCreate").descending());
        Page<Question> questions = questionService.findByTitleContainingAndType_NameContaining(titleSearch,typeSearch,pageable);
        ModelAndView modelAndView = new ModelAndView("/question/list");
        modelAndView.addObject("questions", questions);
        modelAndView.addObject("titleSearch", titleSearch);
        modelAndView.addObject("typeSearch", typeSearch);
        return modelAndView;
    }


    @GetMapping("/create-question")
    public String showCreateForm(Model model) {
        model.addAttribute("questionDto",new QuestionDto());
        return "/question/create";
    }

    @PostMapping("/create-question")
    public String saveQuestion(@Valid @ModelAttribute QuestionDto questionDto,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new QuestionDto().validate(questionDto,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "Thêm mới không thành công!");
            return "/question/create";
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionDto,question);
        question.setDateCreate(LocalDate.now());
        questionService.save(question);
        model.addAttribute("message","Thêm mới thành công!!");
        return "/question/create";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        questionService.remove(id);
        return "redirect:/questions";
    }
}
