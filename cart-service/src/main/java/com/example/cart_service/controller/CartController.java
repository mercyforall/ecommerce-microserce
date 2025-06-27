package com.example.cart_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cart_service.dto.CartItemDto;
import com.example.cart_service.repository.CartItemRepository;
import com.example.cart_service.service.CartService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemRepository cartItemRepository;

    @GetMapping("{userId}")
    public List<CartItemDto> getCart(@PathVariable Long userId) {
        return cartService.getCartByUser(userId);
    }

@PostMapping
public CartItemDto addToCart(@RequestBody CartItemDto cartItemDto) {
    return cartService.addToCart(cartItemDto);

    @DeleteMapping("/{userId}/{productId}")
    public void removeFromCart(@PathVariable Long userId, @PathVariable Long productId) {
        cartService.removeFromCart(userId, productId);
    }

}
