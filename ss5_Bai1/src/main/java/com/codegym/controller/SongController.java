package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.model.SongForm;
import com.codegym.service.ISongService;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

@Controller
@RequestMapping("/song")
@PropertySource("classpath:upload_file.properties")
public class SongController {
    @Autowired
    private ISongService songService;

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("")
    public String index(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveSong(@ModelAttribute SongForm songForm) {
        MultipartFile multipartFile = songForm.getSong();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getSong().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getName(), songForm.getSinger(), songForm.getType(), fileName);
        songService.save(song);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songForm", songForm);
        modelAndView.addObject("message", "Add new song successfully !");
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        songService.remove(id);
        return "redirect:/song";
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showCreateForm(@PathVariable int id) throws IOException {
        ModelAndView modelAndView = new ModelAndView("/edit");
        Song song = songService.findById(id);
        SongForm songForm = new SongForm();
        songForm.setId(id) ;
        songForm.setName(song.getName());
        songForm.setSinger(song.getSinger());
        songForm.setType(song.getType());
        File file = new File(fileUpload+song.getSong());
        FileItem fileItem = new DiskFileItem("file", Files.probeContentType(file.toPath()),
                false, file.getName(), (int) file.length(), file.getParentFile());

        // Đọc dữ liệu từ tệp và ghi vào FileItem
        try (InputStream fileInputStream = new FileInputStream(file);
             OutputStream output = fileItem.getOutputStream()) {
            IOUtils.copy(fileInputStream, output);
        }
        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
        songForm.setSong(multipartFile);
        modelAndView.addObject("songForm",songForm);
        return modelAndView;
    }
    @PostMapping("/update")
    public String update(@ModelAttribute SongForm songForm,
                       Model model,
                       RedirectAttributes redirectAttributes){
        MultipartFile multipartFile = songForm.getSong();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getSong().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getName(), songForm.getSinger(), songForm.getType(), fileName);
        songService.update(song.getId(), song);

        redirectAttributes.addFlashAttribute("mess","cap nhat thanh cong");
        return "redirect:/song";
    }
}
