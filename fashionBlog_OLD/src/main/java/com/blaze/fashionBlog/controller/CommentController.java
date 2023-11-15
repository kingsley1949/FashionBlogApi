package com.blaze.fashionBlog.controller;

import com.blaze.fashionBlog.entity.Comment;
import com.blaze.fashionBlog.entity.Customer;
import com.blaze.fashionBlog.service.CommentService;
import com.blaze.fashionBlog.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class CommentController {
    private final CommentService commentService;
    private final CustomerService customerService;

    @Autowired
    public CommentController(CommentService commentService, CustomerService customerService) {
        this.commentService = commentService;
        this.customerService = customerService;
    }

    @PostMapping("/createComment/{postId}/{customerId}")
    public ResponseEntity<?> createCommentForPost(@PathVariable Long postId, @PathVariable Long customerId, @RequestBody Comment comment) {

        Customer customer = customerService.findCustomerById(customerId);

        if (customer == null) {
            return ResponseEntity.badRequest().body("Customer not found.");
        }
        comment.setCustomer(customer);
        Comment createdComment = commentService.createCommentForPost(postId, comment);

        if (createdComment != null) {
            return ResponseEntity.ok("Comment created successfully.");
        }

        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create the comment.");
        }
    }

}
