package com.blaze.fashionBlog.service;

import com.blaze.fashionBlog.DTO.CustomerResponseDTO;
import com.blaze.fashionBlog.DTO.LoginRequestDTO;
import com.blaze.fashionBlog.entity.Customer;
import com.blaze.fashionBlog.exceptions.CantLogin;
import com.blaze.fashionBlog.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginCustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public LoginCustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public CustomerResponseDTO login(LoginRequestDTO loginRequestDTO){

        ModelMapper modelMapper = new ModelMapper();
       Optional<Customer> loggedInCustomer = customerRepo.findFirstByEmailAndPassword(loginRequestDTO.getEmail(),loginRequestDTO.getPassword());
       if (loggedInCustomer.isPresent()){
          Customer customer = loggedInCustomer.get();
           return modelMapper.map(customer,CustomerResponseDTO.class);
       }
       else {
           throw new CantLogin("Email not found or password is incorrect");
       }

    }
}
