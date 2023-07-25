package com.codegym.ss6_bai2.service;

import com.codegym.ss6_bai2.model.Blog;
import com.codegym.ss6_bai2.repository.IBlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog create(Blog blog) {
        if (blog.getTitle() == null  || blog.getTitle().isEmpty()) {
            return null;
        }
        if (blog.getContent() == null  || blog.getContent().isEmpty()) {
            return null;
        }
        return blogRepository.save(blog);
    }

    @Override
    public Blog update(int id, Blog blog) {
        Blog fromDB = blogRepository.findById(id).orElse(null);
        if (fromDB == null) {
            return null;
        }
        fromDB.setTitle(blog.getTitle());
        fromDB.setContent(blog.getContent());
        return blogRepository.save(fromDB);    }

    @Override
    public void remove(int id) {

        blogRepository.deleteById(id);
    }
}
