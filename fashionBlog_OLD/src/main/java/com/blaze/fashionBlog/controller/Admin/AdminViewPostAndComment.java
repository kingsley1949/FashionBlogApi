package com.blaze.fashionBlog.controller.Admin;

import com.blaze.fashionBlog.entity.*;
import com.blaze.fashionBlog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/api/v1")
public class AdminViewPostAndComment {

    private final BlogService blogService;

    @Autowired
    public AdminViewPostAndComment(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<?> showSinglePost(@PathVariable Long postId) {
        BlogPost blogPost = blogService.getBlogPostById(postId);
        if (blogPost != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("blogger", blogPost);
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.badRequest().body("Post not found");
        }
    }

}
