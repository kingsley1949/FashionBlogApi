package com.blaze.fashionBlog.service.AdminService;

import com.blaze.fashionBlog.entity.BlogPost;
import com.blaze.fashionBlog.exceptions.FailToFillAllDetails;
import com.blaze.fashionBlog.repository.BlogPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminCreatePostService {

    private final BlogPostRepo blogPostRepo;

    @Autowired
    public AdminCreatePostService(BlogPostRepo blogPostRepo) {
        this.blogPostRepo = blogPostRepo;
    }

    public BlogPost createBlogPost(BlogPost blogPost){
        if (blogPost.getTitle() == null || blogPost.getTitle().isEmpty()){
            throw new FailToFillAllDetails("Title is required");
        }
        else {
            return blogPostRepo.save(blogPost);
        }
    }
}
