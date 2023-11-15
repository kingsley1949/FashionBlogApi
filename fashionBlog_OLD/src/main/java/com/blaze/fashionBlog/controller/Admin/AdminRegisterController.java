package com.blaze.fashionBlog.controller.Admin;

import com.blaze.fashionBlog.DTO.CustomerResponseDTO;
import com.blaze.fashionBlog.entity.Admin;
import com.blaze.fashionBlog.service.AdminService.AdminRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AdminRegisterController {

    private final AdminRegisterService adminRegisterService;

    @Autowired
    public AdminRegisterController(AdminRegisterService adminRegisterService) {
        this.adminRegisterService = adminRegisterService;

    }

    @PostMapping("/registerAdmin")
    public CustomerResponseDTO createAdmin(@RequestBody Admin admin){
       return adminRegisterService.createAdmin(admin);
    }





}
