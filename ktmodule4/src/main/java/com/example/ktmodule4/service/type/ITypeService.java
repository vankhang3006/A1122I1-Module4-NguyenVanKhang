package com.example.ktmodule4.service.type;



import com.example.ktmodule4.model.Type;
import com.example.ktmodule4.service.IGeneralService;

import java.util.List;

public interface ITypeService extends IGeneralService<Type> {
    List<Type> findAll();
}
