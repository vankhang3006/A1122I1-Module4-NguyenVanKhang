package com.codegym.ss7_bai1.service.blog;

import com.codegym.ss7_bai1.model.Blog;
import com.codegym.ss7_bai1.model.Category;
import com.codegym.ss7_bai1.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBlogService extends IGeneralService<Blog> {
    Iterable<Blog> findAllByCategory(Category category);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
    Iterable<Blog> findAll();
}
