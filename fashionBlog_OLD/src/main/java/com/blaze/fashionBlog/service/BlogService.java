package com.blaze.fashionBlog.service;


import com.blaze.fashionBlog.entity.BlogPost;
import com.blaze.fashionBlog.repository.BlogPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    private final BlogPostRepo blogPostRepo;

    @Autowired
    public BlogService(BlogPostRepo blogPostRepo) {
        this.blogPostRepo = blogPostRepo;
    }


    public BlogPost getBlogPostById(Long id){
        return blogPostRepo.findById(id).orElse(null);
    }







}
