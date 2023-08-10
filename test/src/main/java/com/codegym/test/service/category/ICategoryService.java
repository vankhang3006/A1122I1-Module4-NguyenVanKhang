package com.codegym.test.service.category;



import com.codegym.test.model.Category;
import com.codegym.test.service.IGeneralService;

import java.util.List;

public interface ICategoryService extends IGeneralService<Category> {
    List<Category> findAll();
    Category findCategoryById(Long id);

}
