package com.codegym.ss7_bai1.service.blog;

import com.codegym.ss7_bai1.model.Blog;
import com.codegym.ss7_bai1.model.Category;
import com.codegym.ss7_bai1.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBlogService extends IGeneralService<Blog> {
    List<Blog> findAllByCategory(Category category);
    List<Blog> findAll();
    Blog findBlogById(Long id);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAll(Pageable pageable, String title);
}
