package com.blaze.fashionBlog.controller;

import com.blaze.fashionBlog.DTO.CustomerRequestDTO;
import com.blaze.fashionBlog.DTO.CustomerResponseDTO;
import com.blaze.fashionBlog.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CustomerRegisterController {

    private final CustomerService customerService;

    @Autowired
    public CustomerRegisterController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/registerCustomer")
    public CustomerResponseDTO createUser(@RequestBody @Valid CustomerRequestDTO customerRequestDTO) {
        return customerService.createCustomer(customerRequestDTO);
    }
}
