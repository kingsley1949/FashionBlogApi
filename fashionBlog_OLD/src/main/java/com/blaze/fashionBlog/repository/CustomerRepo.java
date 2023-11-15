package com.blaze.fashionBlog.repository;

import com.blaze.fashionBlog.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findFirstByEmailAndPassword(String email,String password);
}
