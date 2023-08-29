package com.example.thi.service;

import com.example.thi.model.Type;

import java.util.List;

public interface ITypeService extends IGeneralService<Type>{
    List<Type> findAll();
}
