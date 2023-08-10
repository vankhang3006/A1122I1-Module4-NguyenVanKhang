package com.codegym.ss7_bai1.service.category;

import com.codegym.ss7_bai1.model.Category;
import com.codegym.ss7_bai1.service.IGeneralService;

import java.util.List;

public interface ICategoryService extends IGeneralService<Category> {
    List<Category> findAll();
}
