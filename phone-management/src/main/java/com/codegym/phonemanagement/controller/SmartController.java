package com.codegym.phonemanagement.controller;

import com.codegym.phonemanagement.model.SmartPhone;
import com.codegym.phonemanagement.service.SmartPhoneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/smartphones")
@AllArgsConstructor
public class SmartController {
    private final SmartPhoneService smartPhoneService;

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> findAll() {
        return new ResponseEntity<>(smartPhoneService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SmartPhone> save(@RequestBody SmartPhone smartphone) {
        return new ResponseEntity<>(smartPhoneService.save(smartphone), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> delete(@PathVariable Long id){
        Optional<SmartPhone> smartphoneOptional = smartPhoneService.findById(id);
        if (smartphoneOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        smartPhoneService.remove(id);

        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.OK);
    }
}