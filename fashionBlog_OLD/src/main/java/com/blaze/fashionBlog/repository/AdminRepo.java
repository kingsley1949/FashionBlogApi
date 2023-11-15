package com.blaze.fashionBlog.repository;

import com.blaze.fashionBlog.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    Optional<Admin> findFirstByEmailAndPassword(String email, String password);
}
