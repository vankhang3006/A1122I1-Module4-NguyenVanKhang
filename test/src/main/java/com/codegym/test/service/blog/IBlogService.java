package com.codegym.test.service.blog;


import com.codegym.test.model.Blog;
import com.codegym.test.model.Category;
import com.codegym.test.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBlogService extends IGeneralService<Blog> {
    List<Blog> findAllByCategory(Category category);
    List<Blog> findAll();
    Blog findBlogById(Long id);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByTitleContaining(String title, Pageable pageable);
    Page<Blog> findByContentContaining(String content, Pageable pageable);
    List<Blog> findByTitleContainingOrContentContaining(String q);
}
