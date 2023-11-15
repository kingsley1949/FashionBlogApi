package com.blaze.fashionBlog.controller.Admin;


import com.blaze.fashionBlog.entity.BlogPost;
import com.blaze.fashionBlog.exceptions.BlogPostNotFound;
import com.blaze.fashionBlog.exceptions.FailToFillAllDetails;
import com.blaze.fashionBlog.service.AdminService.AdminCreatePostService;
import com.blaze.fashionBlog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AdminCreatePost {

    private final AdminCreatePostService adminCreatePostService;

    @Autowired
    public AdminCreatePost(AdminCreatePostService adminCreatePostService) {
        this.adminCreatePostService = adminCreatePostService;
    }

    @PostMapping("/createPost")
    public ResponseEntity<?> createBlogPost(@RequestBody BlogPost blogPost){
        try {
            BlogPost createdPost = adminCreatePostService.createBlogPost(blogPost);
            return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
        }
        catch (FailToFillAllDetails e){
            return new ResponseEntity<>(new BlogPostNotFound(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
