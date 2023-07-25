package com.codegym.cms.service.blog;

import com.codegym.cms.model.Blog;
import com.codegym.cms.model.Category;
import com.codegym.cms.service.IGeneralService;

public interface IBlogService extends IGeneralService<Blog> {
    Iterable<Blog> findAllByCategory(Category category);

}
