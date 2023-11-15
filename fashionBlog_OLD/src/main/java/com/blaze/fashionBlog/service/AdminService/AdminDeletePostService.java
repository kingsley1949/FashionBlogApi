package com.blaze.fashionBlog.service.AdminService;

import com.blaze.fashionBlog.entity.BlogPost;
import com.blaze.fashionBlog.entity.Comment;
import com.blaze.fashionBlog.exceptions.NullValues;
import com.blaze.fashionBlog.repository.BlogPostRepo;
import com.blaze.fashionBlog.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDeletePostService {

    private final BlogPostRepo blogPostRepo;
    private final CommentRepo commentRepo;

    @Autowired
    public AdminDeletePostService(BlogPostRepo blogPostRepo, CommentRepo commentRepo) {
        this.blogPostRepo = blogPostRepo;
        this.commentRepo = commentRepo;
    }

    public void deleteBlogPostWithComments(Long postId) {
        BlogPost blogPost = blogPostRepo.findById(postId).orElse(null);
        if (blogPost == null) {
            throw new NullValues("this can't be a null value");
        }

        List<Comment> comments = commentRepo.findByBlogPostId(postId);
        commentRepo.deleteAll(comments);

        // Delete the blog post
        blogPostRepo.deleteById(postId);
    }
}
