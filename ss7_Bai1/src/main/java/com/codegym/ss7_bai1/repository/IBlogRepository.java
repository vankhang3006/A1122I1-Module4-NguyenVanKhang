package com.codegym.ss7_bai1.repository;

import com.codegym.ss7_bai1.model.Blog;
import com.codegym.ss7_bai1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByCategory(Category category);
    Blog findBlogById(Long id);
    Page<Blog> findBlogByTitleContaining(Pageable pageable, String search);
}
