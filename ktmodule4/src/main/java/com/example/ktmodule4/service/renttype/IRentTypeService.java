package com.example.ktmodule4.service.renttype;



import com.example.ktmodule4.model.RentType;
import com.example.ktmodule4.service.IGeneralService;

import java.util.List;
import java.util.Map;


public interface IRentTypeService extends IGeneralService<RentType> {
    List<RentType> findAll();
    Map<Integer, String> priceList();
}
