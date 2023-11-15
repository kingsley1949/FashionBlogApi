package com.blaze.fashionBlog.service.AdminService;

import com.blaze.fashionBlog.DTO.CustomerResponseDTO;
import com.blaze.fashionBlog.entity.Admin;
import com.blaze.fashionBlog.exceptions.CantLogin;
import com.blaze.fashionBlog.repository.AdminRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminLoginService {

    private final AdminRepo adminRepo;

    @Autowired
    public AdminLoginService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }


    public CustomerResponseDTO loginAdmin(Admin admin){

        ModelMapper modelMapper = new ModelMapper();
        Optional<Admin> loggedInAdmin = adminRepo.findFirstByEmailAndPassword(admin.getEmail(),admin.getPassword());
        if (loggedInAdmin.isPresent()){
            Admin mapadmin = loggedInAdmin.get();
            return modelMapper.map(mapadmin,CustomerResponseDTO.class);
        }
        else {
            throw new CantLogin("Email not found or password is incorrect");
        }

    }
}
