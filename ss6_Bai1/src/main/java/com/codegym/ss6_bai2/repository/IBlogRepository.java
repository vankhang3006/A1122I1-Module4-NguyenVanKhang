package com.codegym.ss6_bai2.repository;

import com.codegym.ss6_bai2.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

}
