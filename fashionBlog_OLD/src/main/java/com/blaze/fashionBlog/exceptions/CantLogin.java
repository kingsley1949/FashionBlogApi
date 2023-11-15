package com.blaze.fashionBlog.exceptions;

public class CantLogin extends RuntimeException{
    public CantLogin(String message){
        super(message);
    }
}
