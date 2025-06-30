package com.example.payment_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.payment_service.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Additional query methods can be defined here if needed   

}
