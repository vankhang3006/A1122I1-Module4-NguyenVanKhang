package com.codegym.ss8_bai2.controller;

import com.codegym.ss8_bai2.dto.SongDto;
import com.codegym.ss8_bai2.model.Song;
import com.codegym.ss8_bai2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping()
    public String showAll(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList",songList);
        return "/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("songDto",new SongDto());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute SongDto songDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("messCreate","Create successfully");
        return "redirect:/song";
    }
    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model) {
        Song song = songService.findById(id);
        model.addAttribute("song",song);
        return "/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Song song,
                         RedirectAttributes redirectAttributes){
        songService.save(song);
        redirectAttributes.addFlashAttribute("messUpdate","Update successfully");
        return "redirect:/song";

    }

}
