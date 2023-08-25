package com.example.ktmodule4.service.type;


import com.example.ktmodule4.model.Type;
import com.example.ktmodule4.repository.ITypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService implements ITypeService{
    @Autowired
    private ITypeRepository typeRepository;
    @Override
    public Optional<Type> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Type type) {
        typeRepository.save(type);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }
}
