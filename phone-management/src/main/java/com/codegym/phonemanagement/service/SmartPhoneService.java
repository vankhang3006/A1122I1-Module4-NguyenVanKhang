package com.codegym.phonemanagement.service;

import com.codegym.phonemanagement.model.SmartPhone;
import com.codegym.phonemanagement.repository.SmartPhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class SmartPhoneService {
    private final SmartPhoneRepository smartPhoneRepository;

    public Iterable<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    public SmartPhone save(SmartPhone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);
    }
}

