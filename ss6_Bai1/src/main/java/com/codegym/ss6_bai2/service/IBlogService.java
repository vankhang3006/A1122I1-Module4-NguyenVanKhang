package com.codegym.ss6_bai2.service;

import com.codegym.ss6_bai2.model.Blog;


import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(int id);

    Blog create(Blog blog);

    Blog update(int id, Blog blog);
    void remove(int id);
}
