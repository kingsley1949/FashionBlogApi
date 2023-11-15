package com.blaze.fashionBlog.exceptions;

public class BlogPostNotFound extends RuntimeException {
    public BlogPostNotFound(String message){
        super(message);
    }

}
