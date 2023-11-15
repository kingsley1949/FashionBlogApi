package com.blaze.fashionBlog.service.AdminService;

import com.blaze.fashionBlog.DTO.CustomerResponseDTO;
import com.blaze.fashionBlog.entity.Admin;
import com.blaze.fashionBlog.exceptions.NullValues;
import com.blaze.fashionBlog.repository.AdminRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminRegisterService {

    private final AdminRepo adminRepo;

    @Autowired
    public AdminRegisterService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    public CustomerResponseDTO createAdmin(Admin admin){
        if (admin.getFirstName() == null || admin.getLastName().isEmpty() || admin.getPassword().isEmpty()){
            throw new NullValues("name and password can't be empty or null");
        }

        Admin register = new Admin();
        ModelMapper mapper = new ModelMapper();

        register.setFirstName(admin.getFirstName());
        register.setLastName(admin.getLastName());
        register.setEmail(admin.getEmail());
        register.setPassword(admin.getPassword());

        adminRepo.save(admin);
        return mapper.map(admin,CustomerResponseDTO.class);

    }

}
