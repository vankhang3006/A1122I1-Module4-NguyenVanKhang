package com.codegym.test.controller.restful;

import com.codegym.test.model.Blog;
import com.codegym.test.model.Category;

import com.codegym.test.service.blog.IBlogService;
import com.codegym.test.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;
    /* Xem danh sách các category */
    @GetMapping("/categorys")
    public ResponseEntity<List<Category>> getListCategory(){
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }
    /* Xem danh sách các bài viết */
    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getListBlog(){
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    /* Xem danh sách các bài viết của một category */
    @GetMapping("/blogs/category/{id}")
    public ResponseEntity<List<Blog>> getListBlogByCategory(@PathVariable Long id){
        Category category = categoryService.findCategoryById(id);
        List<Blog> blogs = blogService.findAllByCategory(category);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    /* Xem chi tiết một bài viết */
    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable Long id){
        Blog blog = blogService.findBlogById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Blog>> search(@RequestParam String q){
        return new ResponseEntity<>(blogService.findByTitleContainingOrContentContaining(q), HttpStatus.OK);
    }
}
