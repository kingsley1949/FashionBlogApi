package com.blaze.fashionBlog.controller.Admin;

import com.blaze.fashionBlog.DTO.CustomerResponseDTO;
import com.blaze.fashionBlog.entity.Admin;
import com.blaze.fashionBlog.service.AdminService.AdminLoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AdminLoginController {

    private final AdminLoginService adminLoginService;

    public AdminLoginController(AdminLoginService adminLoginService) {
        this.adminLoginService = adminLoginService;
    }

    @PostMapping("/loginAdmin")
    public CustomerResponseDTO loginCustomer(@RequestBody Admin admin){
        return adminLoginService.loginAdmin(admin);
    }
}
