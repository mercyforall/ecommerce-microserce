package com.example.cart_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cart_service.dto.CartItemDto;
import com.example.cart_service.model.CartItem;
import com.example.cart_service.repository.CartItemRepository;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItemDto> getCartByUser(Long userId) {
       return cartItemRepository.findByUserId(userId)
                .stream()
                .map(this::toDTO).collect(Collectors.toList());
                
    }

    public CartItemDto addToCart(CartItemDto dto) {
        CartItem item = new CartItem();
        item.setUserId(dto.getUserId());
        item.setProductId(dto.getProductId());
        item.setQuantity(dto.getQuantity());
        CartItem saved = cartItemRepository.save(item);
        return toDTO(saved);
    }

    public void removeFromCart(Long userId, Long productId) {
        cartItemRepository.deleteByUserIdAndProductId(userId, productId);
    }

    private CartItemDto toDTO(CartItem item) {
        return new CartItemDto(item.getId(), item.getUserId(), item.getProductId(), item.getQuantity());
    }
}
// End of file: cart-service/src/main/java/com/example/cart_service/service/CartService.java