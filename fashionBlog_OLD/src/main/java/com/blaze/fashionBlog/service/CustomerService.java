package com.blaze.fashionBlog.service;

import com.blaze.fashionBlog.DTO.CustomerRequestDTO;
import com.blaze.fashionBlog.DTO.CustomerResponseDTO;
import com.blaze.fashionBlog.entity.Customer;
import com.blaze.fashionBlog.exceptions.FailToFillAllDetails;
import com.blaze.fashionBlog.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO){

        if (customerRequestDTO.getFirstname() == null || customerRequestDTO.getFirstname().isEmpty()
        || customerRequestDTO.getEmail().isEmpty() || customerRequestDTO.getPassword().isEmpty()){
            throw new FailToFillAllDetails("please fill in all our details");
        }

        ModelMapper modelMapper = new ModelMapper();
        Customer customer = new Customer();

        customer.setFirstname(customerRequestDTO.getFirstname());
        customer.setLastname(customerRequestDTO.getLastname());
        customer.setEmail(customerRequestDTO.getEmail());
        customer.setPassword(customerRequestDTO.getPassword());

           customerRepo.save(customer);
           return modelMapper.map(customer,CustomerResponseDTO.class);
    }

    public Customer findCustomerById(Long customerId) {
        return customerRepo.findById(customerId).orElse(null);
    }
}
