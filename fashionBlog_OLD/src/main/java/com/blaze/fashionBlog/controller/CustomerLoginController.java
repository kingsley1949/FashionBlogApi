package com.blaze.fashionBlog.controller;

import com.blaze.fashionBlog.DTO.CustomerResponseDTO;
import com.blaze.fashionBlog.DTO.LoginRequestDTO;
import com.blaze.fashionBlog.service.LoginCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class CustomerLoginController {

    private final LoginCustomerService loginCustomerService;

    @Autowired
    public CustomerLoginController(LoginCustomerService loginCustomerService) {
        this.loginCustomerService = loginCustomerService;
    }

    @PostMapping("/login")
    public CustomerResponseDTO loginCustomer(@RequestBody LoginRequestDTO loginRequestDTO){
      return loginCustomerService.login(loginRequestDTO);
    }

}
