package com.example.ktmodule4.service.area;

import com.example.ktmodule4.model.Area;
import com.example.ktmodule4.service.IGeneralService;

import java.util.List;

public interface IAreaService extends IGeneralService<Area> {
    List<Area> findAll();

}
