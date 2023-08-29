package com.example.thi.service.impl;

import com.example.thi.model.Type;
import com.example.thi.repository.ITypeRepository;
import com.example.thi.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TypeService implements ITypeService {
    @Autowired
    private ITypeRepository typeRepository;

    @Override
    public Optional<Type> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Type type) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }
}
