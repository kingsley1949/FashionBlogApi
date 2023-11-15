package com.blaze.fashionBlog.controller.Admin;

import com.blaze.fashionBlog.repository.BlogPostRepo;
import com.blaze.fashionBlog.service.AdminService.AdminDeletePostService;
import com.blaze.fashionBlog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AdminDeletePost {

    private final BlogPostRepo blogPostRepo;
    private final AdminDeletePostService adminDeletePostService;

    @Autowired
    public AdminDeletePost(BlogPostRepo blogPostRepo,AdminDeletePostService adminDeletePostService) {
        this.blogPostRepo = blogPostRepo;
        this.adminDeletePostService = adminDeletePostService;
    }

    @DeleteMapping("/admin/deletePost/{postId}")
    public ResponseEntity<String> deletePostByAdmin(@PathVariable Long postId) {

        if(blogPostRepo.findBlogPostById(postId).isPresent()){
            adminDeletePostService.deleteBlogPostWithComments(postId);
            return ResponseEntity.ok("Blog post deleted by admin.");
        }

        else {
            return ResponseEntity.ok("Blog postId " + postId + " does not exist");
        }
    }
}
