package com.blaze.fashionBlog.service;

import com.blaze.fashionBlog.entity.BlogPost;
import com.blaze.fashionBlog.entity.Comment;
import com.blaze.fashionBlog.exceptions.BlogPostNotFound;
import com.blaze.fashionBlog.exceptions.FailToFillAllDetails;
import com.blaze.fashionBlog.repository.BlogPostRepo;
import com.blaze.fashionBlog.repository.CommentRepo;
import com.blaze.fashionBlog.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepo commentRepo;
    private final BlogPostRepo blogPostRepo;

    @Autowired
    public CommentService(CommentRepo commentRepo, BlogPostRepo blogPostRepo) {
        this.commentRepo = commentRepo;
        this.blogPostRepo = blogPostRepo;
    }


    public Comment createCommentForPost(Long id, Comment comment){
        BlogPost blogPost = blogPostRepo.findById(id).orElse(null);
        if (blogPost != null){
            comment.setBlogPost(blogPost);
            return commentRepo.save(comment);
        }
        else {
            throw new BlogPostNotFound("post not found for id:" + id);
        }
    }















    public List<Comment> getAllCommentsForPost(Long commentId){
        return commentRepo.findByBlogPostId(commentId);
    }
//    public List<Comment> getAllCommentsForPost(){
//        return commentRepo.findAll();
//    }

    public Comment getCommentById(Long commentId){
        return commentRepo.findById(commentId).orElse(null);
    }



    public List<Comment> searchCommentsByContent(String keyword){
        return  commentRepo.searchByContent(keyword.toLowerCase());
    }


//    public Page<Comment> getPaginatedCommentsForPost(Long id, int page, int size){
//        Pageable pageable = PageRequest.of(page, size, Sort.by("created_at").descending());
//        return commentRepo.findByBlogPostId(id, pageable);
//    }
//    public Page<Comment> getPaginatedCommentsForPost(Long id, Pageable pageable){
//        return commentRepo.findByBlogPostId(id, pageable);
//    }

    public Page<Comment> searchPaginatedComments(String keyword, int page, int size){
    Pageable pageable = PageRequest.of(page, size, Sort.by("created_at").descending());
    return commentRepo.searchByContent(keyword.toLowerCase(), pageable);
    }
}
