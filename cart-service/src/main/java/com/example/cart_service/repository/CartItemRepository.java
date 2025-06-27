package com.example.cart_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cart_service.model.CartItem;
import java.util.List;

public interface CartItemRepository  extends JpaRepository<CartItem, Long> {

    // Custom query methods can be defined here if needed
    List<CartItem> findByUserId(Long userId);

    void deleteByUserIdAndProductId(Long userId, Long productId);

}
