package com.example.ktmodule4.service.renttype;


import com.example.ktmodule4.model.Area;
import com.example.ktmodule4.model.RentType;
import com.example.ktmodule4.service.IGeneralService;

import java.util.List;

public interface IRentTypeService extends IGeneralService<RentType> {
    List<RentType> findAll();
    List<String> priceList();
}
